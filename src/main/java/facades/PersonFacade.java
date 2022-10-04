package facades;

import dtos.PersonDTO;
import dtos.PersonDTO;
import entities.Person;
import entities.RenameMe;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonFacade
{
    private static PersonFacade instance;
    private static EntityManagerFactory emf;



    //Private Constructor to ensure Singleton
    private PersonFacade() {}

    public static PersonFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<PersonDTO> getAll()
    {
        EntityManager em = getEntityManager();
        try
        {
        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        List<Person> people = query.getResultList();
        return PersonDTO.getDTOs(people);
    }
    finally{
        em.close();
    }
    }

    public int countAll(){
        EntityManager em = getEntityManager();
        int count;
        TypedQuery<Integer> query = em.createQuery("select count(p) from Person p", Integer.class);
        count = query.getSingleResult();
        em.close();
        return count;
    }


    public PersonDTO createPerson(Person person){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PersonDTO(person);
    }
}
