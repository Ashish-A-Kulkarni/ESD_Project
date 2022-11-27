package com.academia.coursecreation.Bean;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int course_id;

    @Column(nullable = false, unique = true)
    private String course_code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String term;

    @Column(nullable = false)
    private int credits;

    @Column(nullable = false)
    private int capacity;

    @ManyToOne
    @JoinTable(name = "Specialisation_Course")
    private Specialisation specialisation;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="Course_Prerequisite")
    private List<Courses> prerequisites;

//    @OneToOne
//    @JoinColumn(name="faculty")
//    private Employee coursefaculty;

    //Remaining
    //specialization
    //prerequisite

    public Courses(){

    }

    public Courses(int course_id, String course_code, String name, String description, String year, String term, int credits, int capacity,Specialisation specialisation, List<Courses> prerequisites){
        this.course_id=course_id;
        this.course_code=course_code;
        this.name=name;
        this.description=description;
        this.year=year;
        this.term=term;
        this.credits=credits;
        this.capacity=capacity;
        this.specialisation=specialisation;
        this.prerequisites=prerequisites;
    }


    public String getCourse_code() {
        return course_code;
    }

    public void setCourse_code(String course_code) {
        this.course_code = course_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Courses{" +
                "course_id=" + course_id +
                ", course_code='" + course_code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", year='" + year + '\'' +
                ", term='" + term + '\'' +
                ", credits='" + credits + '\'' +
                ", capacity='" + capacity + '\'' +
                '}';
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }
    public void setCourse_id(String course_id) {
        this.course_code = course_id;
    }

    public Specialisation getSpecialisation() {
        return specialisation;
    }

    public void setSpecialisation(Specialisation specialisation) {
        this.specialisation = specialisation;
    }

    public List<Courses> getPrerequisites() {
        return prerequisites;
    }

    public void setPrerequisites(List<Courses> prerequisites) {
        this.prerequisites = prerequisites;
    }
}