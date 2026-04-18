package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/module")
public class ModuleWs {

    static ModuleBusiness helper = new ModuleBusiness();

    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        return Response.status(200)
                .entity(helper.getAllModules())
                .build();
    }

    @Path("/add")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addModule(Module module) {

        if (module == null) {
            return Response.status(400).entity("Invalid data").build();
        }

        boolean added = helper.addModule(module);

        if (added) {
            return Response.status(201).entity("Module added successfully").build();
        } else {
            return Response.status(500).entity("Error adding module").build();
        }
    }

    @Path("/update/{matricule}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateModule(@PathParam("matricule") String matricule, Module module) {

        boolean updated = helper.updateModule(matricule, module);

        if (updated) {
            return Response.status(200).entity("Module updated successfully").build();
        } else {
            return Response.status(404).entity("Module not found").build();
        }
    }

    @Path("/delete/{matricule}")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteModule(@PathParam("matricule") String matricule) {

        boolean deleted = helper.deleteModule(matricule);

        if (deleted) {
            return Response.status(200).entity("Module deleted successfully").build();
        } else {
            return Response.status(404).entity("Module not found").build();
        }
    }
}