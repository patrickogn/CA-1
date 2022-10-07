package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import dtos.PersonHasHobbyDTO;
import dtos.PhoneDTO;
import facades.PersonFacade;
import facades.PersonHasHobbyFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/person")
public class PersonResource {


    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final PersonFacade FACADE =  PersonFacade.getInstance(EMF);
    private static final PersonHasHobbyFacade FACADE1 =  PersonHasHobbyFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Person World!";
    }

    //hhhh
    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        List<PersonDTO> personDTOList = FACADE.getAll();
        return GSON.toJson(personDTOList);
    }
    @GET
    @Path("city/{zipcode}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPhoneById(@PathParam("zipcode")int zipcode){
        List<PersonDTO> personDTOList = FACADE.getPeopleWithZip(zipcode);
        return GSON.toJson(personDTOList);
    }

    @GET
    @Path("hobby/{hobbyid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHobbyById(@PathParam("hobbyid")int hobbyid){
        List<PersonHasHobbyDTO> personDTOList = FACADE.getPeopleWithGivenHobby(hobbyid);
        return GSON.toJson(personDTOList);
    }
    @GET
    @Path("counthobby/{hobbyid}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getHobbyCountById(@PathParam("hobbyid")int hobbyid){
        long peoplewithgivenhobby = FACADE.countAll(hobbyid);
        return GSON.toJson(peoplewithgivenhobby);
    }
}
