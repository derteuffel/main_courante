package com.derteuffel.ressources;

import com.derteuffel.dao.EvenementRepository;
import com.derteuffel.dao.UserRepository;
import com.derteuffel.entities.Evenement;
import com.derteuffel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Service
public class UserRessources {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EvenementRepository evenementRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Query("select u from User u where u.equipe.id=:id")
    public Page<User> findByEquipe(Long id, Pageable pageable, String type) {
        return userRepository.findByEquipe(id, pageable, type);
    }


    public Page<User> findByEvenements(@Param("id") Long id, String type, Pageable pageable) {
        return userRepository.findByEvenements(id, type, pageable);
    }

    /*  public List<User> findByEquipe(Long id) {
        List<User> users=userRepository.findAll();
        List<User> result= new ArrayList<>();

        for (User user:users){
            if (user.getEquipe().getId().equals(id)){
                result.add(user);
            }
        }
        return result;
    }

    public Set<User> findByEvenement(Long id) {

        Optional<Evenement> evenementOptional=evenementRepository.findById(id);
        Set<User> users=evenementOptional.get().getUsers();
        return users;
    }*/
}
