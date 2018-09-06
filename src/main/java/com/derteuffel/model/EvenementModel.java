package com.derteuffel.model;

import com.derteuffel.entities.Evenement;
import com.derteuffel.ressources.EvenementRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Controller
public class EvenementModel {

    @Autowired
    private EvenementRessources evenementRessources;


    @GetMapping("/evenements/get/user/{id}")
    public String findByUser(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("evenements", evenementRessources.findByUser(id));
        return "user/evenement/list";
    }

    @GetMapping("/evenements/get/nature/{nature}")
    public String findByNature(@PathVariable(name = "nature") String nature, Model model) {

        model.addAttribute("evenements", evenementRessources.findByNature(nature));
        return "evenement/list";
    }

    @GetMapping("/evenement/form")
    public String evenementEditForm(Model model, @PathVariable(required = false, name = "id") Long id){

            model.addAttribute("evvenement", new Evenement());
        return "evenement/edit";
    }

    @PostMapping("/evenements/save")
    public String save( Evenement evenement, Model model) {

        model.addAttribute("evenements", evenementRessources.findAll());
         evenementRessources.save(evenement);

        return "evenement/list";
    }

    @GetMapping("/evenements/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id, Model model) {
        evenementRessources.deleteById(id);

        model.addAttribute("evenements", evenementRessources.findAll());

        return "evenement/list";
    }

    @GetMapping("/evenements/get/saisine/{saisine}")
    public String findBySaisine(@PathVariable(name = "saisine") String saisine, Model model) {

        model.addAttribute("evenements", evenementRessources.findBySaisine(saisine));

        return "evenement/list";
    }

    @GetMapping("/evenements/get/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("evenement", evenementRessources.findById(id));
        return "evenement/view";
    }

    @GetMapping("/evenements/get/equipe/{id}")
    public String findByEquipe(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("evenements", evenementRessources.findByEquipe(id));
        return "equipe/evenement/list";
    }

    @GetMapping("/evenements/get")
    public String findAll(Model model) {

        model.addAttribute("evenements", evenementRessources.findAll());
        return "evenement/list";
    }
}
