package com.derteuffel.dao;

import com.derteuffel.entities.Autre_Materiel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by derteuffel on 01/09/2018.
 */
@Repository
public interface Autre_MaterielRepository  extends JpaRepository<Autre_Materiel,Long> {
}
