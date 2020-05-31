package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;

@Entity
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Person person;

    private int score;

    @OneToOne
    @JoinColumn(name = "party_id")
    private Party party;

    @ManyToOne
    private Election election;

    public Vote() {
    }

    public Vote(Party party, Election election, int score) {
        this.party = party;
        this.election = election;
        this.score = score;
    }

    public Vote(Long id, Party party, Election election, int score) {
        this.id = id;
        this.party = party;
        this.election = election;
        this.score = score;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
                ", score=" + score +
                '}';
    }
}
