package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.HobbyDTO;
import facades.HobbyFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/hobby")
public class HobbyResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();
    private static final HobbyFacade FACADE =  HobbyFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Hobby World!";
    }


    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllHobbies(){
        List<HobbyDTO> hobbyDTOList = FACADE.getAllHobbies();
        return GSON.toJson(hobbyDTOList);
    }
}