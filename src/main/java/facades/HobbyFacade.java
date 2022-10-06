package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.PersonHasHobbyDTO;
import entities.Hobby;
import entities.PersonHasHobby;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.WebApplicationException;
import java.util.List;

public class HobbyFacade {
    private static HobbyFacade instance;
    private static EntityManagerFactory emf;


    //Private Constructor to ensure Singleton
    private HobbyFacade() {
    }

    public static HobbyFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new HobbyFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager(EntityManagerFactory emf) {
        return HobbyFacade.emf.createEntityManager();
    }

    public List<HobbyDTO> getAllHobbies() {
        EntityManager em = getEntityManager(emf);
        try {
            TypedQuery<Hobby> query = em.createQuery("select h from Hobby h", Hobby.class);
            List<Hobby> hobbies = query.getResultList();
            return HobbyDTO.getDTOs(hobbies);
        } finally {
            em.close();
        }
    }

    public HobbyDTO createHobby(Hobby hobby) {
        EntityManager em = getEntityManager(emf);
        try {
            em.getTransaction().begin();
            em.persist(hobby);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new HobbyDTO(hobby);
    }
}
