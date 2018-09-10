package com.derteuffel.model;

import com.derteuffel.entities.Equipe;
import com.derteuffel.ressources.EquipeRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Controller
public class EquipeModel {


    @Autowired
    private EquipeRessources equipeRessources;

    /*@GetMapping("/equipes/get/evenement/{id}")
    public String findByEvenements(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("equipe", equipeRessources.findByEvenements(id));
        return "evenement/equipe/list";
    }*/

    @GetMapping("/equipes/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {

        equipeRessources.deleteById(id);

        return "redirect:/equipes/get";
    }

    @GetMapping("/equipes/get")
    public String findAll(Model model, @RequestParam(defaultValue = "0")int page) {

        model.addAttribute("equipes", equipeRessources.findAll(new PageRequest(page,5)));
        model.addAttribute("currentPage",page);
        return "equipe/list";
    }

    @GetMapping("/equipes/form, /equipes/form/{id}")
    public String equipeEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
        if (id != null){
            model.addAttribute("equipe", equipeRessources.findById(id));
        }else {
            model.addAttribute("equipe", new Equipe());
        }
        return "equipe/edit";
    }

    @PostMapping("/equipes/save")
    public String save( Equipe equipe) {

         equipeRessources.save(equipe);
        return "redirect:/equipes/get";
    }

    @GetMapping("/equipes/get/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("equipe", equipeRessources.findById(id));
        return "equipe/view";
    }
}
