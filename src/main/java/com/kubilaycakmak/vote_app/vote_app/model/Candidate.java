package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nation;
    private String spouse;
    private String bio;

    @OneToOne
    private Person person;

    public Candidate() {
    }

    public Candidate(String nation, String spouse, String bio, Person person) {
        this.nation = nation;
        this.spouse = spouse;
        this.bio = bio;
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getSpouse() {
        return spouse;
    }

    public void setSpouse(String spouse) {
        this.spouse = spouse;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", nation='" + nation + '\'' +
                ", spouse='" + spouse + '\'' +
                ", bio='" + bio + '\'' +
                ", person=" + person +
                '}';
    }
}
