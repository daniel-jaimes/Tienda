package api;

import model.Game;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/game")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class GameApi {
    @GET
    @Path("{id}")
    public Response getGameBy(@PathParam("id") int gameId) {
        //TODO codigo
        return Response.ok("El juego con id: ", MediaType.APPLICATION_JSON).build();
    }

    @GET
    public Response getAllGames() {
        //TODO codigo
        return Response.ok("Los juegos con id: ", MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public Response putGame(Game game) {
        //TODO codigo
        return Response.ok("Los componentes: ", MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("{id}")
    public Response updateComponentsByGameId(@PathParam("id") int gameId) {
        //TODO codigo
        return Response.ok("Los componentes: ", MediaType.APPLICATION_JSON).build();
    }
}
