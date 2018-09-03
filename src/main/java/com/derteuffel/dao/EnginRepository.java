package com.derteuffel.dao;

import com.derteuffel.entities.Engin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Repository
public interface EnginRepository extends JpaRepository<Engin, Long> {
}
