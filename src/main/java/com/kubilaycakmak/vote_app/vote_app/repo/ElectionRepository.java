package com.kubilaycakmak.vote_app.vote_app.repo;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import com.kubilaycakmak.vote_app.vote_app.payload.pojo.ElectionParties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, Long> {

    Optional<Election> findById(Long id);

//    @Query(value = "select new com.kubilaycakmak.vote_app.vote_app.model.Election(elec.id, elec.createdBy, elec.parties) from Election as elec ")
//    List<Election> findSpecialized();

    @Query(value="SELECT ep.election_id as id, ep.parties_id as p_id FROM election_parties ep GROUP BY ep.election_id, ep.parties_id", nativeQuery=true)
    List<String> findElectionParties();


    @Query(value="SELECT elec.id, elec.created_by, elec.date_start, " +
            "elec.date_end, elec.description FROM election as elec group by elec.id ORDER BY elec.date_start DESC ", nativeQuery = true)
    List<Election> findElectionById();

    @Query(value="SELECT elec.id, elec.created_by, elec.date_start, " +
            "elec.date_end, elec.description FROM election as elec group by elec.id ORDER BY elec.date_start DESC ", nativeQuery = true)
    List<Object[]> findElections();


}
