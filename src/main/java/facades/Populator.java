/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.*;

import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */

//public PersonDTO(String email, String gender, Integer age, String firstName, String lastName, Adress adress, List<String> adresses, List<String> hobbys, List<String> phonenumbers)

public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();

/*
        Der er ikke auto increment på hobby, derfor indtaster vi hobbier manuelt.
        HobbyFacade hf = HobbyFacade.getInstance(emf);
        hf.createHobby(new Hobby(1, "Fodbold", "futbol"));
        hf.createHobby(new Hobby(2,"Skak", "1000 iq"));
        hf.createHobby(new Hobby(3,"Pokemon samler", "pokemon gotta catch em all"));
        hf.createHobby(new Hobby(4,"Frimaerke samler", "samler paa frimaeker"));
        hf.createHobby(new Hobby(5,"Gamer", "esport"));
        hf.createHobby(new Hobby(6,"Programmering", "vi hader jpa"));*/

        PersonFacade pf = PersonFacade.getInstance(emf);



        Cityinfo cityinfo = new Cityinfo(3760,"Gudhjem");
        Adress adress = new Adress("joboland","7,2,8" ,cityinfo);

        pf.createPerson(new Person("email.com","male",21,"hans", "hansen", adress));


    }
    
    public static void main(String[] args) {
        populate();
    }
}
