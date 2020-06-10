package com.kubilaycakmak.vote_app.vote_app.controller;

import com.kubilaycakmak.vote_app.vote_app.model.ERole;
import com.kubilaycakmak.vote_app.vote_app.model.Person;
import com.kubilaycakmak.vote_app.vote_app.model.Role;
import com.kubilaycakmak.vote_app.vote_app.model.Vote;
import com.kubilaycakmak.vote_app.vote_app.payload.request.LoginRequest;
import com.kubilaycakmak.vote_app.vote_app.payload.request.SignupRequest;
import com.kubilaycakmak.vote_app.vote_app.payload.response.JwtResponse;
import com.kubilaycakmak.vote_app.vote_app.payload.response.MessageResponse;
import com.kubilaycakmak.vote_app.vote_app.repo.PersonRepository;
import com.kubilaycakmak.vote_app.vote_app.repo.RoleRepository;
import com.kubilaycakmak.vote_app.vote_app.repo.VoteRepository;
import com.kubilaycakmak.vote_app.vote_app.security.jwt.JwtUtils;
import com.kubilaycakmak.vote_app.vote_app.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    PersonRepository personRepository;

    @Autowired
    VoteRepository voteRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtUtils jwtUtils;

//    @PostMapping("/vote")
//    public @ResponseBody
//    Iterable<Vote> getVoteInformation(){
//        return voteRepository.findAll();
//    }

    @PostMapping("/signin")
    public ResponseEntity<?> authenticatePerson(@Valid @RequestBody LoginRequest loginRequest){
        System.out.println(loginRequest.getEmail());
        System.out.println(loginRequest.getPassword());

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
        List<String> roles = userDetails.getAuthorities().stream()
                .map(item -> item.getAuthority())
                .collect(Collectors.toList());

        return ResponseEntity.ok(new JwtResponse(jwt,
                userDetails.getId(),
                userDetails.getUsername(),
                userDetails.getEmail(),
                roles));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
        if (personRepository.existsByEmail(signUpRequest.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Email is already taken!"));
        }


        // Create new user's account
        Person person = new Person(
                signUpRequest.getName(),
                signUpRequest.getSurname(),
                encoder.encode(signUpRequest.getPassword()),
                signUpRequest.getGender(),
                signUpRequest.getEmail(),
                signUpRequest.getLastIP(),
                signUpRequest.getLastDevice(),
                signUpRequest.getLastLocation(),
                signUpRequest.getAge(),
                signUpRequest.getNationId()
                );

        Set<String> strRoles = signUpRequest.getRole();
        Set<Role> roles = new HashSet<>();

        if (strRoles == null) {
            Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                    .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
            roles.add(userRole);
        } else {
            strRoles.forEach(role -> {
                switch (role) {
                    case "admin":
                        Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(adminRole);

                        break;
                    case "dev":
                        Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(modRole);

                        break;
                    default:
                        Role userRole = roleRepository.findByName(ERole.ROLE_USER)
                                .orElseThrow(() -> new RuntimeException("Error: Role is not found."));
                        roles.add(userRole);
                }
            });
        }

        person.setRoleSet(roles);
        personRepository.save(person);

        return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
    }
}
