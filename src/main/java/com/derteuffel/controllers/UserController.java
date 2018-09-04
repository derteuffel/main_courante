package com.derteuffel.controllers;

import com.derteuffel.entities.User;
import com.derteuffel.ressources.UserRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRessources userRessources;


    @GetMapping("/users/get")
    public List<User> findAll() {
        return userRessources.findAll();
    }


    @GetMapping("/suspects/equipe/get/{id}")
    public List<User> findByEquipe(@PathVariable Long id) {
        return userRessources.findByEquipe(id);
    }


    @GetMapping("/suspects/evenement/get/{id}")
    public Set<User> findByEvenement(Long id) {
        return userRessources.findByEvenement(id);
    }
}
