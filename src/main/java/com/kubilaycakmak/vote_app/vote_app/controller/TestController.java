package com.kubilaycakmak.vote_app.vote_app.controller;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import com.kubilaycakmak.vote_app.vote_app.model.Person;
import com.kubilaycakmak.vote_app.vote_app.model.Vote;
import com.kubilaycakmak.vote_app.vote_app.payload.request.LoginRequest;
import com.kubilaycakmak.vote_app.vote_app.payload.response.JwtResponse;
import com.kubilaycakmak.vote_app.vote_app.repo.ElectionRepository;
import com.kubilaycakmak.vote_app.vote_app.repo.PersonRepository;
import com.kubilaycakmak.vote_app.vote_app.repo.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    ElectionRepository electionRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    PersonRepository personRepository;

    @GetMapping("/all")
    public String allAccess() {
        return "Public Content.";
    }

    @GetMapping("/user")
    @PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
    public String userAccess() {
        return "User Content.";
    }

    @GetMapping("/mod")
    @PreAuthorize("hasRole('MODERATOR')")
    public String moderatorAccess() {
        return "Moderator Board.";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String adminAccess() {
        return "Admin Board.";
    }

    @GetMapping("/election")
    public @ResponseBody
    Iterable<Election> getElectionInformation(){
        return electionRepository.findAll();
    }

    @PostMapping("/vote")
    public ResponseEntity<?> getVoteInformation(@Valid @RequestBody String auth) {
        {

            return ResponseEntity.ok(
                    voteRepository.findAll()
            );
        }
    }

    @GetMapping("/person")
    public @ResponseBody Iterable<Person> getPersonAll(){
        return personRepository.findAll();
    }

}