package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;

@Entity
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String surname;
    private int age;
    private String nation;
    private String spouse;
    private String bio;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "party_id", referencedColumnName = "id")
    private Party party;

    public Candidate() {
    }

    public Candidate(String name, String surname, int age, String nation, String spouse, String bio, Party party) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nation = nation;
        this.spouse = spouse;
        this.bio = bio;
        this.party = party;
    }

    public Candidate(Long id, String name, String surname, int age, String nation, String spouse, String bio, Party party) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.nation = nation;
        this.spouse = spouse;
        this.bio = bio;
        this.party = party;
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

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
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

    public Party getParty() {
        return party;
    }

    public void setParty(Party party) {
        this.party = party;
    }

    @Override
    public String toString() {
        return "Candidate{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", nation='" + nation + '\'' +
                ", spouse='" + spouse + '\'' +
                ", bio='" + bio + '\'' +
                ", party=" + party +
                '}';
    }
}
