package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    private String name, surname, password, gender, email, lastIP, lastDevice, lastLocation;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    private int age;
    private Long nationId;

    @OneToMany
    private List<Vote> vote;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_role",
            joinColumns = @JoinColumn(name = "person_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roleSet = new HashSet<>();

    public Person() {
    }

    public Person(String name, String surname, String password, String gender, String email, String lastIP, String lastDevice, String lastLocation, int age, Long nationId, Set<Role> roleSet) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.lastIP = lastIP;
        this.lastDevice = lastDevice;
        this.lastLocation = lastLocation;
        this.age = age;
        this.nationId = nationId;
        this.roleSet = roleSet;
    }

    public Person(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public Person(String name, String surname, String password, String gender, String email, String lastIP, String lastDevice, String lastLocation, Address address, int age, Long nationId, List<Vote> vote) {
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.lastIP = lastIP;
        this.lastDevice = lastDevice;
        this.lastLocation = lastLocation;
        this.address = address;
        this.age = age;
        this.nationId = nationId;
        this.vote = vote;
    }

    public Person(Long id, String name, String surname, String password, String gender, String email, String lastIP, String lastDevice, String lastLocation, Address address, int age, Long nationId, List<Vote> vote) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.lastIP = lastIP;
        this.lastDevice = lastDevice;
        this.lastLocation = lastLocation;
        this.address = address;
        this.age = age;
        this.nationId = nationId;
        this.vote = vote;
    }

    public Person(String name, String email, String surname, String gender, String lastIP, String lastDevice, String lastLocation, int age, long nationId, String encode) {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastIP() {
        return lastIP;
    }

    public void setLastIP(String lastIP) {
        this.lastIP = lastIP;
    }

    public String getLastDevice() {
        return lastDevice;
    }

    public Set<Role> getRoleSet() {
        return roleSet;
    }

    public void setRoleSet(Set<Role> roleSet) {
        this.roleSet = roleSet;
    }

    public void setLastDevice(String lastDevice) {
        this.lastDevice = lastDevice;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Long getNationId() {
        return nationId;
    }

    public void setNationId(Long nationId) {
        this.nationId = nationId;
    }

    public List<Vote> getVote() {
        return vote;
    }

    public void setVote(List<Vote> vote) {
        this.vote = vote;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", password='" + password + '\'' +
                ", gender='" + gender + '\'' +
                ", email='" + email + '\'' +
                ", lastIP='" + lastIP + '\'' +
                ", lastDevice='" + lastDevice + '\'' +
                ", lastLocation='" + lastLocation + '\'' +
                ", address=" + address +
                ", age=" + age +
                ", nationId=" + nationId +
                ", vote=" + vote +
                '}';
    }
}
