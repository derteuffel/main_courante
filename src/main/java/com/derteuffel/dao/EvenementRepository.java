package com.derteuffel.dao;

import com.derteuffel.entities.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Repository
public interface EvenementRepository  extends JpaRepository<Evenement, Long>{

    Set<Evenement> findByUsers(Long id);
    List<Evenement> findByNature(String nature);
    List<Evenement> findBySaisine(String saisine);
    Set<Evenement>findByEquipe(Long id);

}
