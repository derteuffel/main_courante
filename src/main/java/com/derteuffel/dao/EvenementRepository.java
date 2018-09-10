package com.derteuffel.dao;

import com.derteuffel.entities.Evenement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Repository
public interface EvenementRepository  extends JpaRepository<Evenement, Long>{

    @Query("SELECT event FROM Evenement event join event.users u where  u.id=:id")
    Page<Evenement> findByUsers(@Param("id") Long id, Pageable pageable);
    Page<Evenement> findByNature(String nature,Pageable pageable);
    Page<Evenement> findBySaisine(String saisine, Pageable pageable);
    @Query("select event from Evenement event where event.equipe.id=:id")
    Page<Evenement>findByEquipe(@Param("id") Long id, Pageable pageable);

}
