package com.kubilaycakmak.vote_app.vote_app.model;

import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.List;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dateOfFoundation;
    private String ideology;

    @OneToOne(mappedBy = "party")
    private Candidate candidate;

    @ManyToMany
    private List<Election> election;

    public Party(String name, String dateOfFoundation, String ideology, Candidate candidate, List<Election> election) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.ideology = ideology;
        this.candidate = candidate;
        this.election = election;
    }

    public Party(Long id, String name, String dateOfFoundation, String ideology, Candidate candidate, List<Election> election) {
        this.id = id;
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.ideology = ideology;
        this.candidate = candidate;
        this.election = election;
    }

    public Party() {
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

    public Candidate getCandidate() {
        return candidate;
    }

    public void setCandidate(Candidate candidate) {
        this.candidate = candidate;
    }

    public List<Election> getElection() {
        return election;
    }

    public void setElection(List<Election> election) {
        this.election = election;
    }

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfFoundation='" + dateOfFoundation + '\'' +
                ", ideology='" + ideology + '\'' +
                ", candidate=" + candidate +
                ", election=" + election +
                '}';
    }
}
