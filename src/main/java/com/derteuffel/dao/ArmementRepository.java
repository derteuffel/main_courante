package com.derteuffel.dao;

import com.derteuffel.entities.Armement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Repository
public interface ArmementRepository extends JpaRepository<Armement, Long> {

    List<Armement> findAllByUser_Id(Long id);

}
