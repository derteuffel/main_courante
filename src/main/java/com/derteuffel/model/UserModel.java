package com.derteuffel.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Controller
public class UserModel {

  /*  @Autowired
    private UserRessources userRessources;


    @GetMapping("/users/get")
    public String findAll(Model model) {

        model.addAttribute("users", userRessources.findAll());
        return "user/list";
    }

    @GetMapping("/users/get/evenement/{id}/{type}")
    public String findByEvenement(@PathVariable(name = "id") Long id, Model model, @PathVariable(name = "type") String type, @RequestParam(defaultValue = "0")int page) {
        model.addAttribute("users",userRessources.findByEvenements(id,type, new PageRequest(page,5)));

        return "evenement/user/list";
    }

    @GetMapping("/users/get/equipe/{id}/{type}")
    public String findByEquipe(@PathVariable(name = "id") Long id, Model model,@PathVariable(name = "type")  String type, @RequestParam("0") int page) {
        model.addAttribute("users", userRessources.findByEquipe(id,new PageRequest(page,5),type));

        return "equipe/user/list";
    }
    */
}
