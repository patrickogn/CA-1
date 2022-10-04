/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.RenameMeDTO;
import entities.Adress;
import entities.Cityinfo;
import entities.Person;
import entities.RenameMe;
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
        PersonFacade pf = PersonFacade.getInstance(emf);   // FacadeExample.getFacadeExample(emf);

        Cityinfo cityinfo = new Cityinfo(3760,"Gudhjem");
        Adress adress = new Adress("joboland","7,2,8" ,cityinfo);

        pf.createPerson(new Person("email.com","male",21,"hans", "hansen", adress));
    }
    
    public static void main(String[] args) {
        populate();
    }
}
