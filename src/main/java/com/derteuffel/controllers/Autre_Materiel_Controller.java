package com.derteuffel.controllers;

import com.derteuffel.entities.Autre_Materiel;
import com.derteuffel.model.Autre_MaterielModel;
import com.derteuffel.ressources.Autre_MaterielRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class Autre_Materiel_Controller {

    @Autowired
    private Autre_MaterielRessources autre_materielRessources;


    @GetMapping("/autre/get")
    public List<Autre_Materiel> getAllAutre_Materiel() {
        return autre_materielRessources.getAllAutre_Materiel();
    }

    @DeleteMapping("/autre/delete/{id}")
    public void deleteAutre_Materiel(@PathVariable(name = "id") Long id) {
        autre_materielRessources.deleteAutre_Materiel(id);
    }

    @GetMapping("/autre/get/{id}")
    public Autre_Materiel getAutre_Materiel(@PathVariable(name = "id") Long id) {
        return autre_materielRessources.getAutre_Materiel(id);
    }

    @PostMapping("/autre/save")
    public Autre_Materiel saveAutre_Materiel(@RequestBody Autre_Materiel autre_materiel) {
        return autre_materielRessources.saveAutre_Materiel(autre_materiel);
    }
}
