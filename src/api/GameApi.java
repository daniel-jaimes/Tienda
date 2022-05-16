package api;

import model.Component;
import model.Game;
import service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;
import java.util.ArrayList;

@Path("/game")
@Produces("application/json;charset=UTF-8")
@Consumes("application/json;charset=UTF-8")
public class GameApi {
    private Service service;
    public GameApi(){
        service = Service.getInstance();
    }
    @GET
    @Path("{id}")
    public Response getGameBy(@PathParam("id") int gameId) {
        Game game;
        try {
            game = service.getGameBy(gameId);
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok(game, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/")
    public Response getAllGames() {
        ArrayList<Game> games;
        try {
            games = service.getAllGames();
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok(games, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/")
    public Response putGame(Game game) {
        try {
            service.createGame(game);
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok("Juego creado", MediaType.APPLICATION_JSON).build();
    }

    @POST
    @Path("{id}")
    public Response updateComponentsByGameId(@PathParam("id") int gameId, Game game) {
        try {
            service.updateGame(game);
        } catch (SQLException e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok("Juego modificado", MediaType.APPLICATION_JSON).build();
    }
}
