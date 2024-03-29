package com.kubilaycakmak.vote_app.vote_app.repo;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, Integer> {

    Optional<Election> findById(Long id);

    @Query(value="SELECT * from Election", nativeQuery=true)
    List<Election> findSpecialized();



}
