package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private int person_id;

    @Column(nullable = false)
    private String neighborhood;

    @Column(nullable = false)
    private String city;

    public Address() {
    }

    public Address(String city, String neighborhood) {
        this.city = city;
        this.neighborhood = neighborhood;
    }

    public Address(long id, String neighborhood, String city) {
        this.id = id;
        this.neighborhood = neighborhood;
        this.city = city;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood = neighborhood;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", neighborhood='" + neighborhood + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
