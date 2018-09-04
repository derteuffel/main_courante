package com.derteuffel.dao;

import com.derteuffel.entities.Suspect;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Repository
public interface SuspectRepository extends JpaRepository<Suspect, Long> {

    List<Suspect> findByStatus(String status);
    List<Suspect> findBySituation(String situation);
    List<Suspect> findByDepartement(String departement);
}
