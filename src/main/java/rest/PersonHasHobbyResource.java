package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import dtos.PersonHasHobbyDTO;
import facades.PersonFacade;
import facades.PersonHasHobbyFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hashobby")
public class PersonHasHobbyResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final PersonHasHobbyFacade FACADE =  PersonHasHobbyFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();


    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, World!";
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        List<PersonHasHobbyDTO> personHasHobbyDTOList = FACADE.getAll();
        return GSON.toJson(personHasHobbyDTOList);
    }
}
