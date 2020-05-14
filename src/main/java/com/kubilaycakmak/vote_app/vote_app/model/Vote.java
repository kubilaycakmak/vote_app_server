package com.kubilaycakmak.vote_app.vote_app.model;

import com.sun.deploy.xml.GeneralEntity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Person> person;

    @ManyToOne
    private Election election;

    public Vote() {
    }

    public Vote(List<Person> person, Election election) {
        this.person = person;
        this.election = election;
    }

    public Vote(Long id, List<Person> person, Election election) {
        this.id = id;
        this.person = person;
        this.election = election;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Person> getPerson() {
        return person;
    }

    public void setPerson(List<Person> person) {
        this.person = person;
    }

    public Election getElection() {
        return election;
    }

    public void setElection(Election election) {
        this.election = election;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", person=" + person +
                ", election=" + election +
                '}';
    }
}
