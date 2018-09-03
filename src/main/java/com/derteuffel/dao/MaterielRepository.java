package com.derteuffel.dao;

import com.derteuffel.entities.Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 31/08/2018.
 */

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {

    List<Materiel> findByType(String type);
      List<Materiel> findByStatus(String status);
    List<Materiel> findByEvenement(Long id);
}
