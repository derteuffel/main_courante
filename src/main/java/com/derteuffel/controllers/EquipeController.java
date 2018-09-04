package com.derteuffel.controllers;

import com.derteuffel.entities.Equipe;
import com.derteuffel.ressources.EquipeRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class EquipeController {


    @Autowired
    private EquipeRessources equipeRessources;


   /* @GetMapping("/equipes/evenement/{id}")
    public Equipe findByEvenements(@PathVariable(name = "id") Long id) {
        return equipeRessources.findByEvenements(id);
    }*/

    @DeleteMapping("/equipes/delete/{id}")
    public void deleteById(@PathVariable(name = "id") Long id) {
        equipeRessources.deleteById(id);
    }

    @GetMapping("/equipes/get")
    public List<Equipe> findAll() {
        return equipeRessources.findAll();
    }

    @PostMapping("/equipes/save")
    public Equipe save(@RequestBody Equipe equipe) {
        return equipeRessources.save(equipe);
    }

    @GetMapping("/equipes/get/{id}")
    public Equipe findById(@PathVariable(name = "id") Long id) {
        return equipeRessources.findById(id);
    }
}
