package com.derteuffel.dao;

import com.derteuffel.entities.Personnel;
import com.derteuffel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by derteuffel on 28/08/2018.
 */

@Repository
public interface PersonnelRepository extends JpaRepository<Personnel, Long> {

   public List<Personnel> findByStatus(String status);
}
