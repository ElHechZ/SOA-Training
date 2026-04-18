package webservices;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
@Path("/hello")
public class Hello {
    @Path("/hi")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHello() {
        return Response
                .status(200)
                .entity("Hello World")
                .build();
    }

    @Path("/hi/{fName}")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHiTo(@PathParam(value="fName") String name) {
        return Response
                .status(200)
                .entity("Hello " + name)
                .build();
    }
    @Path("/salut")
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Response sayHiToClass(@QueryParam(value="fName") String name) {
        return Response
                .status(200)
                .entity("Hello " + name)
                .build();
    }
}
