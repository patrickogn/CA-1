package facades;

import dtos.CityinfoDTO;
import dtos.HobbyDTO;
import entities.Cityinfo;
import entities.Hobby;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class CityInfoFacade
{

    private static CityInfoFacade instance;
    private static EntityManagerFactory emf;


    //Private Constructor to ensure Singleton
    private CityInfoFacade() {
    }

    public static CityInfoFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new CityInfoFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager(EntityManagerFactory emf) {
        return CityInfoFacade.emf.createEntityManager();
    }


    public List<CityinfoDTO> getAllZips() {
        EntityManager em = getEntityManager(emf);
        try {
            TypedQuery<Cityinfo> query = em.createQuery("select c from Cityinfo c", Cityinfo.class);
            List<Cityinfo> cityinfos = query.getResultList();
            return CityinfoDTO.getDTOs(cityinfos);
        } finally {
            em.close();
        }
    }

}
