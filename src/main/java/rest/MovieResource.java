package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dtos.MovieDTO;

//Make sure NOT to have any references to your Entity Classes here
//import entities.Movie;
import facades.MovieFacade;
import java.util.List;

import javax.persistence.EntityManagerFactory;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import utils.EMF_Creator;

//Todo Remove or change relevant parts before ACTUAL use
@Path("movie")
public class MovieResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory();

    private static final MovieFacade FACADE = MovieFacade.getMovieFacade(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"This is not a movie\"}";
    }

    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getMovieCount() {
        long count = FACADE.getMovieCount();
        return "{\"count\":" + count + "}";  //Done manually so no need for a DTO
    }

    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getAll() {
        return Response.ok().entity(GSON.toJson(FACADE.getAllMovies())).build();
    }

    @Path("/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getById(@PathParam("id") int id) {
        return Response.ok().entity(GSON.toJson(FACADE.getMovieById(id))).build();
    }

    @Path("title/{title}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getByTitle(@PathParam("title") String title) {
        List<MovieDTO> movies =FACADE.getMoviesByTitle(title);
        if (movies == null || movies.isEmpty()) {
            return Response.status(404).entity("{\"code\":404,\"msg\":\"Movie not found\"}").build();
        }
        return Response.ok().entity(GSON.toJson(movies)).build();
    }

    @Path("notitle/{title}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public Response getByNoTitle(@PathParam("title") String title) {
        List<MovieDTO> movies = FACADE.getMoviesByTitle(title);
        if (movies == null || movies.isEmpty()) {
            return Response.status(404).entity("{\"code\":404,\"msg\":\"Movie not found\"}").build();
        }
        return Response.ok(GSON.toJson(movies)).build();
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    public String create(MovieDTO movie) {
        MovieDTO result = FACADE.createMovie(movie.getYear(), movie.getTitle(), movie.getActors());
        return GSON.toJson(result);
    }

    @PUT
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void update(MovieDTO entity, @PathParam("id") int id) {
        throw new UnsupportedOperationException();
    }
}
