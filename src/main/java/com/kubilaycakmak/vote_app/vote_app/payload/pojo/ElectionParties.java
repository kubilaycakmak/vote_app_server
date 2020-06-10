package com.kubilaycakmak.vote_app.vote_app.payload.pojo;

import com.kubilaycakmak.vote_app.vote_app.model.Party;
import com.kubilaycakmak.vote_app.vote_app.model.Score;

import java.util.Date;
import java.util.List;
import java.util.Set;

public class ElectionParties {

    private Long id;
    private Date dateStart;
    private Date dateEnd;
    private String createdBy;
    private String description;
    private Set<Party> parties;
    private Set<Score> score;

    public ElectionParties(Long id, Date dateStart, Date dateEnd, String createdBy, String description, Set<Party> parties, Set<Score> score) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.createdBy = createdBy;
        this.description = description;
        this.parties = parties;
        this.score = score;
    }

    public ElectionParties(Long id, Date dateStart, Date dateEnd, String createdBy, String description, Set<Party> parties) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.createdBy = createdBy;
        this.description = description;
        this.parties = parties;
    }



    public ElectionParties(Long id, Date dateStart, Date dateEnd, String createdBy, String description) {
        this.id = id;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.createdBy = createdBy;
        this.description = description;
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

    public Set<Party> getParties() {
        return parties;
    }

    public void setParties(Set<Party> parties) {
        this.parties = parties;
    }

    public Set<Score> getScore() {
        return score;
    }

    public void setScore(Set<Score> score) {
        this.score = score;
    }
}
