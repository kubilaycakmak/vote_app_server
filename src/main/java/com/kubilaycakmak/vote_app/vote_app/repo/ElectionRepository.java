package com.kubilaycakmak.vote_app.vote_app.repo;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, Long> {

    Optional<Election> findById(Long id);

//    @Query("select '*' from 'election_parties'")
//    List<Election> findSpecialized();

}
