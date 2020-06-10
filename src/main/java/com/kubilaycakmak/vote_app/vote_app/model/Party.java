package com.kubilaycakmak.vote_app.vote_app.model;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dateOfFoundation;
    private String ideology;
    private int person_id;


    public Party() {
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfFoundation() {
        return dateOfFoundation;
    }

    public void setDateOfFoundation(String dateOfFoundation) {
        this.dateOfFoundation = dateOfFoundation;
    }

    public String getIdeology() {
        return ideology;
    }

    public void setIdeology(String ideology) {
        this.ideology = ideology;
    }


    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfFoundation='" + dateOfFoundation + '\'' +
                ", ideology='" + ideology + '\'' +
                ", candidate=" + person_id +
                '}';
    }
}
