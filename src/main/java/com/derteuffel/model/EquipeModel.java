package com.derteuffel.model;

import com.derteuffel.entities.Equipe;
import com.derteuffel.ressources.EquipeRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

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
    public String deleteById(@PathVariable(name = "id") Long id, Model model) {

        equipeRessources.deleteById(id);

        model.addAttribute("equipes", equipeRessources.findAll());

        return "equipe/list";
    }

    @GetMapping("/equipes/get")
    public String findAll(Model model) {

        model.addAttribute("equipes", equipeRessources.findAll());
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
    public String save(@RequestBody Equipe equipe, Model model) {

         equipeRessources.save(equipe);

        model.addAttribute("equipes", equipeRessources.findAll());
        return "equipe/list";
    }

    @GetMapping("/equipes/get/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("equipe", equipeRessources.findById(id));
        return "equipe/view";
    }
}
