package com.derteuffel.dao;

import com.derteuffel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Set<User> findByEvenement(Long id);
    List<User> findByEquipe(Long id);
}
