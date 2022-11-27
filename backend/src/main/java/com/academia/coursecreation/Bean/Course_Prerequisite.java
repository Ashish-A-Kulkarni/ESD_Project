package com.academia.coursecreation.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="Course_Prerequisite")
public class Course_Prerequisite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String description;

    public Course_Prerequisite(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
