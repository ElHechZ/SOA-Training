package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UeWs {

    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUEs() {
        return Response.status(200).entity(helper.getListeUE()).build();
    }

    @Path("/update/{code}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUE(@PathParam("code") int code, UniteEnseignement ue) {

        boolean updated = helper.updateUniteEnseignement(code, ue);

        if (updated) {
            return Response.status(200).entity("UE updated successfully").build();
        } else {
            return Response.status(404).entity("UE not found").build();
        }
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUE(UniteEnseignement ue) {

        if (ue == null) {
            return Response.status(400).entity("Invalid data").build();
        }

        boolean added = helper.addUniteEnseignement(ue);

        if (added) {
            return Response.status(201).entity("UE added successfully").build();
        } else {
            return Response.status(500).entity("Error adding UE").build();
        }
    }

    @Path("/delete/{code}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteUE(@PathParam("code") int code) {

        boolean deleted = helper.deleteUniteEnseignement(code);

        if (deleted) {
            return Response.status(200).entity("UE deleted successfully").build();
        } else {
            return Response.status(404).entity("UE not found").build();
        }
    }
}