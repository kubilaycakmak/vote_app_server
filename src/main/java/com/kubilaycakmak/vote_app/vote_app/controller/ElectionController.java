package com.kubilaycakmak.vote_app.vote_app.controller;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import com.kubilaycakmak.vote_app.vote_app.payload.response.JwtResponse;
import com.kubilaycakmak.vote_app.vote_app.repo.ElectionRepository;
import com.kubilaycakmak.vote_app.vote_app.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ElectionController {


    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    JwtUtils jwtUtils;

    @GetMapping("/election")
    public String getElectionInformation(){
        return "Hey";
    }
}
