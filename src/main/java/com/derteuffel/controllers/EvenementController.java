package com.derteuffel.controllers;

import com.derteuffel.entities.Evenement;
import com.derteuffel.ressources.EvenementRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class EvenementController {

    @Autowired
    private EvenementRessources evenementRessources;

    @GetMapping("/evenements/users/get/{id}")
    public Set<Evenement> findByUser(@PathVariable(name = "id") Long id) {
        return evenementRessources.findByUser(id);
    }

    @GetMapping("/evenements/nature/get/{nature}")
    public List<Evenement> findByNature(@PathVariable(name = "nature") String nature) {
        return evenementRessources.findByNature(nature);
    }

    @GetMapping("/evenements/saisine/get/{saisine}")
    public List<Evenement> findBySaisine(@PathVariable(name = "saisine") String saisine) {
        return evenementRessources.findBySaisine(saisine);
    }

    @GetMapping("/evenements/equipes/get/{id}")
    public List<Evenement> findByEquipe(@PathVariable(name = "id") Long id) {
        return evenementRessources.findByEquipe(id);
    }

    @DeleteMapping("/evenements/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        evenementRessources.deleteById(id);
    }

    @GetMapping("/evenements/get")
    public List<Evenement> findAll() {
        return evenementRessources.findAll();
    }

    @GetMapping("/evenements/get/{id}")
    public Evenement findById(@PathVariable(name = "id") Long id) {
        return evenementRessources.findById(id);
    }

    @PostMapping("/evenements/save")
    public Evenement save(@RequestBody Evenement evenement) {
        return evenementRessources.save(evenement);
    }
}
