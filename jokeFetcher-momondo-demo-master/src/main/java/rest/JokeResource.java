package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.ChuckDTO;
import dtos.CombinedDTO;
import dtos.DadDTO;
import java.io.IOException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import utils.HttpUtils;

/**
 * REST Web Service
 *
 * @author lam
 */
@Path("jokes")
public class JokeResource {

    @Context
    private UriInfo context;

   
    private String chuckJokeUrl = "https://api.chucknorris.io/jokes/random" ; 
    private String dadJokeUrl = "https://icanhazdadjoke.com"; 
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJokes() throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create(); 
        String chuckjoke = HttpUtils.fetchData(chuckJokeUrl); 
        String dadJoke = HttpUtils.fetchData(dadJokeUrl); 
        ChuckDTO chuckDTO = gson.fromJson(chuckjoke, ChuckDTO.class); 
        DadDTO dadDTO = gson.fromJson(dadJoke, DadDTO.class); 
        
        CombinedDTO combinedDTO = new CombinedDTO (dadDTO, chuckDTO); 
        
        String combinedJSON = gson.toJson(combinedDTO); 
        return combinedJSON; 
        
        
        
      //  return " {\"info\":\"Change me to return jokes as described in the exercise\"}";
    }

   
}
