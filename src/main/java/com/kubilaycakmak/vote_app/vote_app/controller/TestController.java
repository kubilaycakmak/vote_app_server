package com.kubilaycakmak.vote_app.vote_app.controller;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import com.kubilaycakmak.vote_app.vote_app.model.Party;
import com.kubilaycakmak.vote_app.vote_app.model.Person;
import com.kubilaycakmak.vote_app.vote_app.model.Vote;
import com.kubilaycakmak.vote_app.vote_app.payload.pojo.ElectionParties;
import com.kubilaycakmak.vote_app.vote_app.payload.request.LoginRequest;
import com.kubilaycakmak.vote_app.vote_app.payload.request.SignupRequest;
import com.kubilaycakmak.vote_app.vote_app.payload.request.UseVote;
import com.kubilaycakmak.vote_app.vote_app.payload.response.JwtResponse;
import com.kubilaycakmak.vote_app.vote_app.payload.response.MessageResponse;
import com.kubilaycakmak.vote_app.vote_app.repo.ElectionRepository;
import com.kubilaycakmak.vote_app.vote_app.repo.PersonRepository;
import com.kubilaycakmak.vote_app.vote_app.repo.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/test")
public class TestController {

    @Autowired
    AuthenticationManager authenticationManager;

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

//    @GetMapping("/hello")
//    public Map<String, List<String>> sayHello() {
//        HashMap<String, List<String>> map = new HashMap<>();
//        map.put("elections", electionRepository.findElectionParties());
//
//        return map;
//    }

    @GetMapping("/election")
    public List<Election> findElectionById(){
        return electionRepository.findSpecialized();
    }

    @PostMapping("/use/vote")
    public ResponseEntity<?> useVote(@RequestBody UseVote useVote){
        Vote vote = new Vote(
                useVote.getElection_id(),
                useVote.getParty_id(),
                useVote.getPerson_id()
        );
        voteRepository.save(vote);
        return ResponseEntity.ok(new MessageResponse("You have used your vote."));
    }


}