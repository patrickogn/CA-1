package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.CityinfoDTO;
import facades.CityInfoFacade;
import utils.EMF_Creator;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/cityinfo")
public class CityInfoResource
{
    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final CityInfoFacade FACADE =  CityInfoFacade.getInstance(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces("text/plain")
    public String hello() {
        return "Hello, Hobby World!";
    }

/*    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllZips(){
        List<CityinfoDTO> cityinfoDTOList = FACADE.getAllZips();
        return GSON.toJson(cityinfoDTOList);
    }*/
}