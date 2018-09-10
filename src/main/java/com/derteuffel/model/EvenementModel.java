package com.derteuffel.model;

import com.derteuffel.entities.Evenement;
import com.derteuffel.ressources.EvenementRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String findByUser(@PathVariable(name = "id") Long id, Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("evenements", evenementRessources.findByUsers(id,  new PageRequest(page,3)));
        model.addAttribute("currentPage", page);
        return "user/evenement/list";
    }

    @GetMapping("/evenements/get/nature/{nature}")
    public String findByNature(@PathVariable(name = "nature") String nature, Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("evenements", evenementRessources.findByNature(nature, new PageRequest(page,5)));
        return "evenement/list";
    }

    @GetMapping("/evenements/form")
    public String evenementEditForm(Model model, @PathVariable(required = false, name = "id") Long id){

            model.addAttribute("evvenement", new Evenement());
        return "evenement/edit";
    }

    @PostMapping("/evenements/save")
    public String save( Evenement evenement) {

         evenementRessources.save(evenement);

        return "redirect/evenements/get";
    }

    @GetMapping("/evenements/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        evenementRessources.deleteById(id);
        return "redirect:/evenements/get";
    }

    @GetMapping("/evenements/get/saisine/{saisine}")
    public String findBySaisine(@PathVariable(name = "saisine") String saisine, Model model,@RequestParam(defaultValue = "0") int page ) {

        model.addAttribute("evenements", evenementRessources.findBySaisine(saisine, new PageRequest(page,5)));
        model.addAttribute("currentPage", page);

        return "evenement/list";
    }

    @GetMapping("/evenements/get/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("evenement", evenementRessources.findById(id));
        return "evenement/view";
    }

    @GetMapping("/evenements/get/equipe/{id}")
    public String findByEquipe(@PathVariable(name = "id") Long id, Model model, @RequestParam(defaultValue = "0") int page ) {

        model.addAttribute("evenements", evenementRessources.findByEquipe(id, new PageRequest(page,5)));
        model.addAttribute("currentPage", page);
        return "evenement/equipe/list";
    }

    @GetMapping("/evenements/get")
    public String findAll(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("evenements", evenementRessources.findAll(new PageRequest(page,5)));
        model.addAttribute("currentPage", page);
        return "evenement/list";
    }
}
