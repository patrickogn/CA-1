package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.PersonDTO;
import dtos.PhoneDTO;
import facades.PersonFacade;
import facades.PhoneFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/phone")
public class PhoneResource
{

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final PhoneFacade FACADE =  PhoneFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Person World!";
    }


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAll(){
        List<PhoneDTO> phoneDTOList = FACADE.getAll();
        return GSON.toJson(phoneDTOList);
    }
}