package com.kubilaycakmak.vote_app.vote_app.repo;

import com.kubilaycakmak.vote_app.vote_app.model.Election;
import com.kubilaycakmak.vote_app.vote_app.payload.pojo.ElectionParties;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface ElectionRepository extends JpaRepository<Election, Integer> {

    Optional<Election> findById(Long id);

//    @Query("Select new com.kubilaycakmak.vote_app.vote_app.payload.pojo.ElectionParties(v.id, v.dateStart, v.dateEnd, v.createdBy, v.description, v.parties, v.score) from Election as v group by v.id")
    //@Query(nativeQuery=true, value="select * from election inner join election_parties ep on election.id = ep.election_id")
//    @Query(value="SELECT * from Election", nativeQuery=true)
    @Query(value="SELECT * from Election", nativeQuery=true)
    List<Election> findSpecialized();

    @Query(value = "insert into vote (election_id, party_id, person_id) values (1,4,6)", nativeQuery = true)
    String useVote();

//    @Query(value="SELECT ep.election_id as id, ep.parties_id as p_id FROM election_parties ep GROUP BY ep.election_id, ep.parties_id", nativeQuery=true)
//    List<String> findElectionParties();
//
//
//    @Query(value="SELECT elec.id, elec.created_by, elec.date_start, " +
//            "elec.date_end, elec.description FROM election as elec group by elec.id ORDER BY elec.date_start DESC ", nativeQuery = true)
//    List<Election> findElectionById();

//    @Query("select new com.kubilaycakmak.vote_app.vote_app.model.Election")
//
//    @Query(value="SELECT elec.id, elec.created_by, elec.date_start, " +
//            "elec.date_end, elec.description FROM election as elec group by elec.id ORDER BY elec.date_start DESC ", nativeQuery = true)
//    List<Object[]> findElections();


}
