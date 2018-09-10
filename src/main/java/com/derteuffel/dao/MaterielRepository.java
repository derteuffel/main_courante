package com.derteuffel.dao;

import com.derteuffel.entities.Materiel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 31/08/2018.
 */

@Repository
public interface MaterielRepository extends JpaRepository<Materiel, Long> {

    Page<Materiel> findByType(String type, Pageable pageable);
      Page<Materiel> findByStatus(String status, Pageable pageable);

}
