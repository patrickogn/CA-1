package facades;

import dtos.PersonDTO;
import dtos.PersonDTO.AdressDTO;
import dtos.HobbyDTO;
import entities.Adress;
import entities.Hobby;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class AdressFacade
{

    private static AdressFacade instance;
    private static EntityManagerFactory emf;



    //Private Constructor to ensure Singleton
    private AdressFacade() {}

    public static AdressFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new AdressFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public List<AdressDTO> getAllHobbies()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<Adress> query = em.createQuery("select a from Adress a", Adress.class);
            List<Adress> adresses = query.getResultList();
            return PersonDTO.AdressDTO.getDTOs(adresses);
        }
        finally{
            em.close();
        }
    }

    public AdressDTO createAdress(Adress adress){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(adress);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new AdressDTO(adress);
    }
}