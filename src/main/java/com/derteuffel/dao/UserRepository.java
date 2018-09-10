package com.derteuffel.dao;

import com.derteuffel.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User u join u.evenements event where  event.id=:id and u.type=:type")
    Page<User> findByEvenements(@Param("id") Long id, @Param("type")String type, Pageable pageable);
    @Query("select u from User u where u.equipe.id=:id and u.type=:type")
    Page<User> findByEquipe(@Param("id")Long id, Pageable pageable,@Param("type") String type);
}
