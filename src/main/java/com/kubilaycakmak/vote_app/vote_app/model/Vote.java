package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;

@Entity
@Table(uniqueConstraints=@UniqueConstraint(columnNames="person_id"))
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    @OneToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne
    private Election election;

    public Vote() {
    }

    public Vote(Party party, Election election) {
        this.party = party;
        this.election = election;
    }

    public Vote(Long id, Party party, Election election) {
        this.id = id;
        this.party = party;
        this.election = election;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
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
                ", party=" + party +
                ", election=" + election +
                '}';
    }
}
