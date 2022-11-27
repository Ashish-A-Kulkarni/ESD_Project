package com.academia.coursecreation.Bean;

import jakarta.persistence.*;

@Entity
@Table(name="Specialisation")
public class Specialisation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specialisation_id;

    @Column(nullable = false, unique = true)
    private String code;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private int credits;

    public Specialisation(){

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getSpecialisation_id() {
        return specialisation_id;
    }

    public void setSpecialisation_id(int specialisation_id) {
        this.specialisation_id = specialisation_id;
    }
}
