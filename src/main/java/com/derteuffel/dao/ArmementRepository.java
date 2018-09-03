package com.derteuffel.dao;

import com.derteuffel.entities.Armement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Repository
public interface ArmementRepository extends JpaRepository<Armement, Long> {
    //Armement findByUser(Long id, String type);
}
