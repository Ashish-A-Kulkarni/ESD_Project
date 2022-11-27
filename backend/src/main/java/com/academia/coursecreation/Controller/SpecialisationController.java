package com.academia.coursecreation.Controller;

import com.academia.coursecreation.Bean.Specialisation_Course;
import com.academia.coursecreation.DAO.DAOImplmentation.SpecialisationDAOImpl;
import com.academia.coursecreation.DAO.SpecialisationDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/Specialisation")
public class SpecialisationController {

    SpecialisationDAO spcDAO = new SpecialisationDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Specialisation(Specialisation_Course spcourse){
        System.out.printf(String.valueOf(spcourse));
        if(spcDAO.addSpecialisation(spcourse)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding specialisation").build();
    }
}
