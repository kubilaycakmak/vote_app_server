package com.kubilaycakmak.vote_app.vote_app.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class Election {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date dateStart;
    private Date dateEnd;
    private String createdBy;
    private String description;


    @OneToMany
    private List<Party> parties;

    @OneToMany
    private List<Candidate> candidates;

    public Election() {
    }

    public Election(Date dateStart, Date dateEnd, String createdBy, String description, List<Party> parties) {
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.createdBy = createdBy;
        this.description = description;
        this.parties = parties;
    }

    public Election(Long id, Date dateStart, Date dateEnd, String createdBy, String description, List<Party> parties) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.createdBy = createdBy;
        this.description = description;
        this.parties = parties;
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

    public List<Party> getParties() {
        return parties;
    }

    public void setParties(List<Party> parties) {
        this.parties = parties;
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
