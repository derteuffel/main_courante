package com.derteuffel.controllers;

import com.derteuffel.entities.Requerant;
import com.derteuffel.ressources.RequerantRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class RequerantController {

    @Autowired
    private RequerantRessources requerantRessources;

    @GetMapping("/requerants/get")
    public List<Requerant> findAll() {
        return requerantRessources.findAll();
    }

    @GetMapping("/requerants/get/{id}")
    public Requerant findById(@PathVariable Long id) {
        return requerantRessources.findById(id);
    }

    @PostMapping("/requerants/save")
    public Requerant save(@RequestBody Requerant requerant) {
        return requerantRessources.save(requerant);
    }

    @DeleteMapping("/requerants/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        requerantRessources.deleteById(id);
    }
}
