package com.derteuffel.dao;

import com.derteuffel.entities.Personnel;
import com.derteuffel.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 28/08/2018.
 */

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

   public Page<Personnel> findByStatus(String status, Pageable pageable);


}
