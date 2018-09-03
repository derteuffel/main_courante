package com.derteuffel.dao;

import com.derteuffel.entities.Equipe;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by derteuffel on 03/09/2018.
 */
public interface EquipeRepository extends JpaRepository<Equipe, Long> {

    public Equipe findByEvenements(Long id);
}
