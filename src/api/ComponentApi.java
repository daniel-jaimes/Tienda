package api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/component")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ComponentApi {

    @GET
    @Path("{id}")
    public Response getComponentById(@PathParam("id") int componentId){
        return Response.ok("", MediaType.APPLICATION_JSON).build();
    }

    @GET
    public Response getAllComponents(){
        return Response.ok("", MediaType.APPLICATION_JSON).build();
    }

    @PUT
    public void putComponent(){}
}
