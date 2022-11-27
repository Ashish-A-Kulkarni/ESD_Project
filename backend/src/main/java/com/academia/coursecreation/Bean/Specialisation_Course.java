package com.academia.coursecreation.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="Specialisation_Course")
public class Specialisation_Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "description")
    private String description;

    public Specialisation_Course() {

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
