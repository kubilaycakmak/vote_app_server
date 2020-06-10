package com.kubilaycakmak.vote_app.vote_app.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import javax.servlet.http.Part;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @JsonProperty("election_id")
    private Long id;
    private Date dateStart;
    private Date dateEnd;
    private String createdBy;
    private String description;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Party> parties;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Score> score;

    public Election() {
    }

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
    }

    public List<Score> getScore() {
        return score;
    }

    public void setScore(List<Score> score) {
        this.score = score;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    public Date getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(Date dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "Election{" +
                "id=" + id +
                ", dateStart=" + dateStart +
                ", dateEnd=" + dateEnd +
                ", createdBy='" + createdBy + '\'' +
                ", description='" + description + '\'' +
                ", parties=" + parties +
                '}';
    }
}
