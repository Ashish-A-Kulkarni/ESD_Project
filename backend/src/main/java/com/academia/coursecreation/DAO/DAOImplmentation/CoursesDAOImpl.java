package com.academia.coursecreation.DAO.DAOImplmentation;

import com.academia.coursecreation.Bean.Courses;
import com.academia.coursecreation.Bean.Specialisation;
import com.academia.coursecreation.Util.HibernateSessionUtil;
import com.academia.coursecreation.DAO.CoursesDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CoursesDAOImpl implements CoursesDAO{

    @Override
    public boolean addCourse(Courses courseObj) {
        try(Session session = HibernateSessionUtil.getSession()){  // session created got access of hibernate session object
            Transaction transaction = session.beginTransaction();  // transaction initiated
            session.save(courseObj);                                 // using session object to save java object into MySQL
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

    @Override
    public List<Courses> getCourseList() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Courses> courseList = new ArrayList<>();
            for (final Object d : session.createQuery("from Courses ").list()) {
                courseList.add((Courses) d);
            }
            return courseList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }

    @Override
    public Courses getCourseByID(int courseID) {
        try (Session session = HibernateSessionUtil.getSession()) {
            return session.get(Courses.class, courseID);
        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
        }
        return null;
    }

    public List<Specialisation> getSpecialisation() {
        try (Session session = HibernateSessionUtil.getSession()){
            List<Specialisation> specList = new ArrayList<>();
            for (final Object d : session.createQuery("from Specialisation ").list()) {
                specList.add((Specialisation) d);
            }
            return specList;

        } catch (HibernateException exception) {
            System.out.print(exception.getLocalizedMessage());
            return null;
        }
    }
}
