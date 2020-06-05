package com.kubilaycakmak.vote_app.vote_app.payload.pojo;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;

public class ElectionParties {

    private Long election_id;
    private String created_by;

    public ElectionParties(Long election_id, String created_by) {
        this.election_id = election_id;
        this.created_by = created_by;
    }
}
