package com.academia.coursecreation.Controller;

import com.academia.coursecreation.Bean.Courses;
import com.academia.coursecreation.Bean.Specialisation;
import com.academia.coursecreation.DAO.CoursesDAO;
import com.academia.coursecreation.DAO.DAOImplmentation.CoursesDAOImpl;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/courses")
public class CourseController {
    CoursesDAO courseDAO = new CoursesDAOImpl();

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response add_Courses(Courses course){
        System.out.printf(String.valueOf(course));
        if(courseDAO.addCourse(course)){
            return Response.status(200).entity("Success").build();
        }
        return Response.status(400).entity("Failure while adding courses").build();
    }

    @GET
    @Path("/get_all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_courses(){
        List<Courses> colist = this.courseDAO.getCourseList();

        return Response.status(200).entity(colist).build();
    }

    @GET
    @Path("/get/{c_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_PLAIN)
    public Response get_employee(@PathParam("c_id") int id){
        System.out.println(id);

        Courses cor = this.courseDAO.getCourseByID(id);
        cor.setCourse_code(cor.getCourse_code());
        System.out.println(cor);

        return Response.status(200).entity(cor).build();
    }

    @GET
    @Path("/getSpecialisation")
    @Produces(MediaType.APPLICATION_JSON)
    public Response get_all_specialisation(){
        List<Specialisation> speclist = this.courseDAO.getSpecialisation();

        return Response.status(200).entity(speclist).build();
    }

}
