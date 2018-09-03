package com.derteuffel.model;

import com.derteuffel.entities.User;
import com.derteuffel.ressources.UserRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Controller
public class UserModel {

    @Autowired
    private UserRessources userRessources;


    @GetMapping("/users/get")
    public String findAll(Model model) {

        model.addAttribute("users", userRessources.findAll());
        return "user/list";
    }

    @GetMapping("/users/get/evenement/{id}")
    public String findByEvenement(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("users",userRessources.findByEvenement(id));

        return "user/list";
    }

    @GetMapping("/users/get/equipe/{id}")
    public String findByEquipe(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("users", userRessources.findByEquipe(id));

        return "user/list";
    }
}
