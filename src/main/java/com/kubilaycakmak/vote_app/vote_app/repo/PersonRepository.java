package com.kubilaycakmak.vote_app.vote_app.repo;

import com.kubilaycakmak.vote_app.vote_app.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface PersonRepository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
    Boolean existsByEmail(String email);
}
