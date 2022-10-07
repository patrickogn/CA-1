package facades;

import dtos.PersonDTO;
import dtos.PersonHasHobbyDTO;
import entities.PersonHasHobby;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
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

    private EntityManager getEntityManager(EntityManagerFactory emf) {
        return PersonHasHobbyFacade.emf.createEntityManager();
    }

    public List<PersonHasHobbyDTO> getAll()
    {
        EntityManager em = getEntityManager(emf);
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

    public List<PersonHasHobbyDTO> PeopleWithGivenHobby(int hobbyid)
    {
        EntityManager em = getEntityManager(emf);
        try
        {
            Query query = em.createQuery("select person.id from PersonHasHobby WHERE hobby.id = :hobbyid", PersonHasHobby.class);
            List<PersonHasHobby> peopleandhobbies = query.getResultList();
            return PersonHasHobbyDTO.getSpeceficHobbies(peopleandhobbies);
        }
        finally{
            em.close();
        }
    }

    public int countAll(){
        EntityManager em = getEntityManager(emf);
        int count;
        TypedQuery<Integer> query = em.createQuery("select count(p) from PersonHasHobby p", Integer.class);
        count = query.getSingleResult();
        em.close();
        return count;
    }
}

//    public List<PersonDTO> getPeopleWithHobby(int hobbyid) {
//        EntityManager em = getEntityManager();
//        int count;
//        TypedQuery<Integer> query = em.createQuery("select count(p) from Person p", Integer.class);
//        count = query.getSingleResult();
//        em.close();
//        return count;}}


/*        EntityManager em = getEntityManager(emf);
        try {
            // PersonHasHobby personHasHobby = em.find(PersonHasHobby.class, hobbyid);
            Query query = em.createQuery("select p from PersonHasHobby p where p.hobby=;" + hobbyid);
            List<PersonDTO> peoplewithhobby = query.getResultList();
            if (peoplewithhobby != null) {
                return peoplewithhobby;
            }
            throw new WebApplicationException("Hobby with id  =" + hobbyid + "does not exist");

        } finally {
            em.close();
        }
    }*/


