package com.derteuffel.dao;

import com.derteuffel.entities.Requerant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Repository
public interface RequerantRepository extends JpaRepository<Requerant, Long> {
}
