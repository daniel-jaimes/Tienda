package api;

import model.Component;
import service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

@Path("/component")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComponentApi {
    private Service service;
    public ComponentApi(){
        service = Service.getInstance();
    }

    @GET
    @Path("/{id}")
    public Response getComponentById(@PathParam("id") int componentId) {
        Component component;
        try {
            component = service.getComponentById(componentId);
        }catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok(component, MediaType.APPLICATION_JSON).build();
    }

    @GET
    @Path("/")
    public Response getAllComponents() {
        ArrayList<Component> components;
        try {
            components = service.getAllComponents();
        }catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok(components, MediaType.APPLICATION_JSON).build();
    }

    @PUT
    @Path("/")
    public Response putComponent() {
        service.createComponent("", "");
        return Response.ok("", MediaType.APPLICATION_JSON).build();
    }

    @DELETE
    @Path("/")
    public Response deleteComponentByName(@QueryParam("name") String name){
        try {
            service.removeComponentByName(name);
        }catch (Exception e){
            return Response.status(Response.Status.BAD_REQUEST).entity(e.getMessage()).build();
        }
        return Response.ok("", MediaType.APPLICATION_JSON).build();
    }
}
