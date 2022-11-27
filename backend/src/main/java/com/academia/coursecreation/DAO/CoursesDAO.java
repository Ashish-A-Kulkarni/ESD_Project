package com.academia.coursecreation.DAO;

import com.academia.coursecreation.Bean.Courses;
import com.academia.coursecreation.Bean.Specialisation;

import java.util.List;

public interface CoursesDAO {
    boolean addCourse(Courses Obj);
    Courses getCourseByID (int courseID);
    List<Courses> getCourseList();

    List<Specialisation> getSpecialisation();
}
