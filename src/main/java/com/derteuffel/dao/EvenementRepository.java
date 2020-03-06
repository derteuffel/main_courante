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

    List<Evenement> findAllByUsers_Id(Long id);
    List<Evenement> findAllByNature(String nature);
    List<Evenement> findAllBySaisine(String saisine);
    List<Evenement> findAllByEquipe_Id(Long id);

}
