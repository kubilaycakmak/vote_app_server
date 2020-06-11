package com.kubilaycakmak.vote_app.vote_app.payload.request;

import javax.validation.constraints.NotBlank;

public class UseVote {

    @NotBlank
    private Long election_id;
    @NotBlank
    private Long party_id;
    @NotBlank
    private Long person_id;

    public UseVote(@NotBlank Long election_id, @NotBlank Long party_id, @NotBlank Long person_id) {
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

    public Long getParty_id() {
        return party_id;
    }

    public void setParty_id(Long party_id) {
        this.party_id = party_id;
    }

    public Long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }
}
