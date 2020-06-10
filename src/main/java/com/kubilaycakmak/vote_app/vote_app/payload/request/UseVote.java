package com.kubilaycakmak.vote_app.vote_app.payload.request;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import com.kubilaycakmak.vote_app.vote_app.model.Party;
import com.kubilaycakmak.vote_app.vote_app.model.Person;

import javax.servlet.http.Part;
import javax.validation.constraints.NotBlank;

public class UseVote {

    @NotBlank
    private Long election_id;
    @NotBlank
    private int party_id;
    @NotBlank
    private int person_id;

    public UseVote(@NotBlank Long election_id, @NotBlank int party_id, @NotBlank int person_id) {
        this.election_id = election_id;
        this.party_id = party_id;
        this.person_id = person_id;
    }

    public Long getElection_id() {
        return election_id;
    }

    public void setElection_id(Long election_id) {
        this.election_id = election_id;
    }

    public int getParty_id() {
        return party_id;
    }

    public void setParty_id(int party_id) {
        this.party_id = party_id;
    }

    public int getPerson_id() {
        return person_id;
    }

    public void setPerson_id(int person_id) {
        this.person_id = person_id;
    }
}
