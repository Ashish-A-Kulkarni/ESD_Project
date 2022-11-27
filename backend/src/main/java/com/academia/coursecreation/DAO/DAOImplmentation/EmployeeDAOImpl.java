package com.academia.coursecreation.DAO.DAOImplmentation;

import com.academia.coursecreation.Bean.Employee;
import com.academia.coursecreation.DAO.EmployeeDAO;
import com.academia.coursecreation.Util.HibernateSessionUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public Employee login(Employee employee) {
        try (Session session = HibernateSessionUtil.getSession()){
            String EmployeeEmail = employee.getEmail();
            String EmployeePassword = employee.getPassword();

            List<Object> result = new ArrayList<Object>(
                    session.createQuery(
                                    "FROM Employee WHERE email = :EmployeeEmail and password = :EmployeePassword"
                            )
                            .setParameter("EmployeeEmail", EmployeeEmail)
                            .setParameter("EmployeePassword", EmployeePassword)
                            .list()
            );

            // If no valid Student found, return null so that login failure is understood
            if (result.size() == 0)
                return null;
            else
                return (Employee) result.get(0);
        }
        catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }

        return null;
    }
}
