package facades;

import dtos.PersonDTO;
import dtos.PhoneDTO;
import entities.Person;
import entities.Phone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.TypedQuery;
import java.util.List;

public class PhoneFacade
{
    private static PhoneFacade instance;
    private static EntityManagerFactory emf;

    private PhoneFacade() {}

    public static PhoneFacade getInstance(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PhoneFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }



    public List<PhoneDTO> getAll()
    {
        EntityManager em = getEntityManager();
        try
        {
            TypedQuery<Phone> query = em.createQuery("select p from Phone p", Phone.class);
            List<Phone> phones = query.getResultList();
            return PhoneDTO.getPhonedtos(phones);
        }
        finally{
            em.close();
        }
    }


    public PhoneDTO createPhone(Phone phone){
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(phone);
            em.getTransaction().commit();
        } finally {
            em.close();
        }
        return new PhoneDTO(phone);
    }

}