package controllers;

import models.RendezVous;
import services.RendezVousBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
@Path("/RDV")
public class RendezVousController {
    public static RendezVousBusiness rendezVousMetier = new RendezVousBusiness();
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addRDV")
    public Response addrendezVous(RendezVous r) {
        if(rendezVousMetier.addRendezVous(r))
            return  Response.status(Response.Status.CREATED).build();
        return  Response.status(Response.Status.NOT_ACCEPTABLE).build();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getRDVByref/{ref}")
    public Response getRendezVousByLogementRef(@PathParam("ref") String refLogement) {
        List<RendezVous> liste=new ArrayList<RendezVous>();
        if(refLogement != null) {
            liste = rendezVousMetier.getListeRendezVousByLogementReference(Integer.parseInt(refLogement));

        } else {
            liste = rendezVousMetier.getListeRendezVous();
        }

        if(liste.size()==0)
            return  Response.status(Response.Status.NOT_FOUND).build();
        return  Response.status(Response.Status.OK).entity(liste).build();
    }

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/updateRDV/{id}")
    public Response updateRdv(RendezVous updatedRendezVous, @PathParam("id") int id) {

        if (rendezVousMetier.updateRendezVous(id,updatedRendezVous)) {
            return Response.status(Response.Status.OK).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @DELETE
    @Path("/deleteRDVById/{id}")
    public  Response deleteRendezVous(@PathParam("id") int id){
        if(rendezVousMetier.deleteRendezVous(id))
            return Response.status(Response.Status.OK).build();


        return Response.status(Response.Status.NOT_FOUND).build();

    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getRDVById/{id}")
    public  Response getRendezVousbyId(@PathParam("id") int id){
        if(rendezVousMetier.getRendezVousById(id)!=null)
            return Response.status(Response.Status.OK).entity(rendezVousMetier.getRendezVousById(id)).build();

        return Response.status(Response.Status.NOT_FOUND).build();

    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllRDV")
    public  Response getAllRendezVous(){
        if(rendezVousMetier.getListeRendezVous()!=null)
            return Response.status(Response.Status.OK).entity(rendezVousMetier.getListeRendezVous()).build();

        return Response.status(Response.Status.NOT_FOUND).build();

    }

}
