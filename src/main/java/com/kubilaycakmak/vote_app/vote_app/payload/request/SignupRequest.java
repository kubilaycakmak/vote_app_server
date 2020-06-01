package com.kubilaycakmak.vote_app.vote_app.payload.request;

import com.kubilaycakmak.vote_app.vote_app.model.Address;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 20)
    private String name;

    @NotBlank
    @Size(min = 3, max = 20)
    private String surname;

    @NotBlank
    @Size(min = 3, max = 20)
    private String gender;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastIP;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastDevice;

    @NotBlank
    @Size(min = 3, max = 20)
    private String lastLocation;

//    @NotBlank
//    @Size(min = 3, max = 20)
//    private Address address;

    private int age;

    private long nationId;

    @Size(max = 50)
    @Email
    private String email;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;

    public SignupRequest() {
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender='" + gender + '\'' +
                ", lastIP='" + lastIP + '\'' +
                ", lastDevice='" + lastDevice + '\'' +
                ", lastLocation='" + lastLocation + '\'' +
                ", age=" + age +
                ", nationId=" + nationId +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }

    public SignupRequest(@NotBlank @Size(min = 3, max = 20) String name, @NotBlank @Size(min = 3, max = 20) String surname, @NotBlank @Size(min = 3, max = 20) String gender, @NotBlank @Size(min = 3, max = 20) String lastIP, @NotBlank @Size(min = 3, max = 20) String lastDevice, @NotBlank @Size(min = 3, max = 20) String lastLocation, @NotBlank @Size(min = 2, max = 20) int age, @NotBlank @Size(min = 1, max = 20) long nationId, @Size(max = 50) @Email String email, Set<String> role, @NotBlank @Size(min = 6, max = 40) String password) {
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.lastIP = lastIP;
        this.lastDevice = lastDevice;
        this.lastLocation = lastLocation;
        this.age = age;
        this.nationId = nationId;
        this.email = email;
        this.role = role;
        this.password = password;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public void setLastDevice(String lastDevice) {
        this.lastDevice = lastDevice;
    }

    public String getLastLocation() {
        return lastLocation;
    }

    public void setLastLocation(String lastLocation) {
        this.lastLocation = lastLocation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getNationId() {
        return nationId;
    }

    public void setNationId(long nationId) {
        this.nationId = nationId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<String> getRole() {
        return this.role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }
}
