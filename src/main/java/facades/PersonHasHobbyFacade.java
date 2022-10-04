package facades;

import dtos.PersonDTO;
import dtos.PersonHasHobbyDTO;
import entities.Person;
import entities.PersonHasHobby;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PersonHasHobbyFacade {
    private static PersonHasHobbyFacade instance;
    private static EntityManagerFactory emf;



    //Private Constructor to ensure Singleton
    private PersonHasHobbyFacade() {}

    public static PersonHasHobbyFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonHasHobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<PersonHasHobbyDTO> getAll()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<PersonHasHobby> query = em.createQuery("select p from PersonHasHobby p", PersonHasHobby.class);
            List<PersonHasHobby> peopleandhobbies = query.getResultList();
            return PersonHasHobbyDTO.getphhDTOs(peopleandhobbies);

        }
        finally{
            em.close();
        }
    }

    public int countAll(){
        EntityManager em = getEntityManager();
        int count;
        TypedQuery<Integer> query = em.createQuery("select count(p) from PersonHasHobby p", Integer.class);
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
