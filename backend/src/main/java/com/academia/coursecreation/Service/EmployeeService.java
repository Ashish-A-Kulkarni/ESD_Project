package com.academia.coursecreation.Service;

import com.academia.coursecreation.Bean.Employee;
import com.academia.coursecreation.DAO.DAOImplmentation.EmployeeDAOImpl;

public class EmployeeService {
    EmployeeDAOImpl employeeDAO = new EmployeeDAOImpl();

    public Employee login(Employee employee){
        Employee loggedInEmployee = employeeDAO.login(employee);

        // If no login happens, then return null
        if (loggedInEmployee == null)
            return null;

        // Setting billList to null to avoid cyclic dependency issues

        return loggedInEmployee;
    }
}
