package com.derteuffel.controllers;

import com.derteuffel.entities.Suspect;
import com.derteuffel.ressources.SuspectRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class SuspectController {


    @Autowired
    private SuspectRessources suspectRessources;

    @GetMapping("/suspects/get")
    public List<Suspect> getAllSuspect() {
        return suspectRessources.findAll();
    }

    @GetMapping("/suspects/status/{status}")
    public List<Suspect> findByStatus(@PathVariable String status) {
        return suspectRessources.findByStatus(status);
    }


    @GetMapping("/suspects/get/{id}")
    public Suspect getSuspect(@PathVariable Long id) {
        return suspectRessources.findById(id);
    }

    @DeleteMapping("/suspects/delete/{id}")
    public void deleteSuspect(@PathVariable Long id) {
        suspectRessources.deleteById(id);
    }


    @GetMapping("/suspects/situation/{situation}")
    public List<Suspect> getAllBySituation(@PathVariable String situation) {
        return suspectRessources.findBySituation(situation);
    }

    @GetMapping("/suspects/departement/{departement}")
    public List<Suspect> findByDepartement(@PathVariable String departement) {
        return suspectRessources.findByDepartement(departement);
    }

    @PostMapping("/suspects/save")
    public Suspect save(@RequestBody Suspect suspect) {
        return suspectRessources.save(suspect);
    }
}
