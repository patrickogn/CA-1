package facades;

import dtos.CityinfoDTO;
import dtos.PersonDTO;
import dtos.PersonDTO;
import dtos.PersonHasHobbyDTO;
import entities.Cityinfo;
import entities.Person;
import entities.PersonHasHobby;
import entities.RenameMe;
import utils.EMF_Creator;

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

    public long countAll(int hobbyid){
        EntityManager em = getEntityManager();
        long count;
        TypedQuery<Long> query = em.createQuery("select count(p) from PersonHasHobby p where p.hobby.id= :hobbyid", Long.class);
        query.setParameter("hobbyid",hobbyid);
        count = query.getSingleResult();
        em.close();
        return count;
    }
  //  select p from PersonHasHobby p where p.hobby.id = :hobbyid", PersonHasHobby.class

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

    public List<PersonDTO> getPeopleWithZip(int zipcode) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> query = em.createQuery("select p from Person p where p.adress.cityinfo.id = :zipcode", Person.class);
            query.setParameter("zipcode",zipcode);
            List<Person> cityinfos = query.getResultList();
            return PersonDTO.getDTOs(cityinfos);
        } finally {
            em.close();
        }
    }
    public List<PersonHasHobbyDTO> getPeopleWithGivenHobby(int hobbyid) {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<PersonHasHobby> query = em.createQuery("select p from PersonHasHobby p where p.hobby.id = :hobbyid", PersonHasHobby.class);
           // TypedQuery<Person> query = em.createQuery("select p from PersonHasHobby p where p.hobby.id = :hobbyid", Person.class);
            query.setParameter("hobbyid",hobbyid);
            List<PersonHasHobby> personList = query.getResultList();
            return PersonHasHobbyDTO.getphhDTOs(personList);
        } finally {
            em.close();
        }
    }
}
