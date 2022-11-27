package com.academia.coursecreation.Controller;

import com.academia.coursecreation.Bean.Employee;
import com.academia.coursecreation.Service.EmployeeService;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/employee")
public class EmployeeController {

    EmployeeService employeeService = new EmployeeService();

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(Employee employee) {
        Employee loggedInStudent = employeeService.login(employee);

        if (loggedInStudent == null)
            return Response.status(401).build();
        else
            return Response.ok().entity(loggedInStudent).build();
    }
}
