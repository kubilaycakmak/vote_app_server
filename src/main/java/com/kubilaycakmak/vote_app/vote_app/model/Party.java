package com.kubilaycakmak.vote_app.vote_app.model;
import javax.persistence.*;

@Entity
public class Party {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String dateOfFoundation;
    private String ideology;

    @OneToOne
    private Candidate candidate;

    public Party(String name, String dateOfFoundation, String ideology, Candidate candidate) {
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.ideology = ideology;
        this.candidate = candidate;
    }

    public Party(Long id, String name, String dateOfFoundation, String ideology, Candidate candidate) {
        this.id = id;
        this.name = name;
        this.dateOfFoundation = dateOfFoundation;
        this.ideology = ideology;
        this.candidate = candidate;
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

    @Override
    public String toString() {
        return "Party{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfFoundation='" + dateOfFoundation + '\'' +
                ", ideology='" + ideology + '\'' +
                ", candidate=" + candidate +
                '}';
    }
}
