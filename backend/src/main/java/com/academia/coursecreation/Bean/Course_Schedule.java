package com.academia.coursecreation.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="Course_Schedule")
public class Course_Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String time;

    @OneToOne
    @JoinColumn(name="course_id")
    private Courses course;

    @Column(nullable = false)
    private String day;

    @Column(nullable = false)
    private String room;

    @Column
    private String building;

    public Course_Schedule(){

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Courses getCourse() {
        return course;
    }

    public void setCourse(Courses course) {
        this.course = course;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }
}
