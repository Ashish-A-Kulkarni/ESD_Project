package com.academia.coursecreation.DAO.DAOImplmentation;

import com.academia.coursecreation.Bean.Specialisation_Course;
import com.academia.coursecreation.Util.HibernateSessionUtil;
import com.academia.coursecreation.DAO.SpecialisationDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SpecialisationDAOImpl implements SpecialisationDAO{

    @Override
    public boolean addSpecialisation(Specialisation_Course Obj) {
        try(Session session = HibernateSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated

            session.save(Obj);                                 // using session object to save java object into MySQL
            transaction.commit();                                  // committing transaction
            return true;
        }
        catch (HibernateException exception) {
            // if Hibernate Exception occurs return false
            // for related exception we can maintain separate logger / Sysout messages for easy debugging
            System.out.println("Hibernate Exception");
            System.out.print(exception.getLocalizedMessage());
            return false;
        }
        catch (Exception e){
            //generalized exception class for any IO / Arithmetic Exception
            System.out.print(e.getLocalizedMessage());
            return false;
        }
    }

}
