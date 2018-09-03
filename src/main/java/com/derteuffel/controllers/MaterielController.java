package com.derteuffel.controllers;

import com.derteuffel.entities.Materiel;
import com.derteuffel.ressources.MaterielRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 31/08/2018.
 */

@RestController
@RequestMapping("/api")
public class MaterielController {

    @Autowired
    private MaterielRessources materielRessources;


    @GetMapping("/materiels")
    public List<Materiel> getAllMateriel() {
        return materielRessources.getAllMateriel();
    }

    @GetMapping("/materiels/{type}")
    public List<Materiel> findByType(@PathVariable(name = "id") String type) {
        return materielRessources.findByType(type);
    }

    @GetMapping("/get_materiel/{id}")
    public Materiel getMateriel(@PathVariable(name = "id") Long id) {
        return materielRessources.getMateriel(id);
    }

    @DeleteMapping("/materieldelete/{id}")
    public void deleteMateriel(@PathVariable(name = "id") Long id) {
        materielRessources.deleteMateriel(id);
    }

    @PostMapping("/save_materiel")
    public Materiel saveMateriel(@RequestBody Materiel materiel) {
        return materielRessources.saveMateriel(materiel);
    }


    @GetMapping("/list_materiel_by_status/{status}")
    public List<Materiel> findByStarus(@PathVariable(name = "id") String status) {
        return materielRessources.findByStarus(status);
    }
}
