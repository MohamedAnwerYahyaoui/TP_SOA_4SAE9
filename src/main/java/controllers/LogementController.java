package controllers;

import filtres.Secured;
import models.Logement;
import services.LogementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/log")
public class LogementController {
    public static LogementBusiness logementMetier = new LogementBusiness();

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addLog")
    public Response addLogement(Logement l) {
        if (l == null) {
            return Response.status(Response.Status.BAD_REQUEST).entity("Invalid Logement data").build();
        }
        if (logementMetier.addLogement(l)) {
            return Response.status(Response.Status.CREATED).build();
        }
        return Response.status(Response.Status.BAD_REQUEST).entity("Failed to add Logement").build();
    }

    @Secured
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllLog")
    public Response getLogements() {
        List<Logement> liste = logementMetier.getLogements();
        if (liste == null || liste.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity("No logements found").build();
        }
        return Response.status(Response.Status.OK).entity(liste).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLogByDelegation/{delegation}")
    public Response getLogementsByDelegation(@PathParam("delegation") String deligation){
        List<Logement> liste = logementMetier.getLogementsByDeleguation(deligation);
        if (liste == null || liste.isEmpty()) {
            return Response.status(Response.Status.NO_CONTENT).entity("No logements found avec cette delegation").build();
        }
        return Response.status(Response.Status.OK).entity(liste).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getLogByReference/{reference}")
    public Response getLogementsByReference(@PathParam("reference") int reference){
        Logement logement = logementMetier.getLogementsByReference(reference);
        if (logement == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("No logements found avec cette reference").build();
        }
        return Response.status(Response.Status.OK).entity(logement).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateLog/{ref}")
    public Response updateLogement(Logement updatedLogement,@PathParam("ref") int reference) {

        if (logementMetier.updateLogement(reference,updatedLogement)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    @DELETE
    @Path("/deleteLogByRef/{ref}")
    public  Response deleteLogement(@PathParam("ref") int reference){
        if(logementMetier.deleteLogement(reference))
            return Response.status(Response.Status.OK).build();


        return Response.status(Response.Status.NOT_FOUND).build();

    }

}
