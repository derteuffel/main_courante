package com.derteuffel.controllers;

import com.derteuffel.entities.Engin;
import com.derteuffel.ressources.EnginRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 03/09/2018.
 */

@RestController
@RequestMapping("/api")
public class EnginController {

    @Autowired
    private EnginRessources enginRessources;

    @GetMapping("/engin/get")
    public List<Engin> getAllEngin() {
        return enginRessources.getAllEngin();
    }

    @GetMapping("/engin/get/{id}")
    public Engin getEngin(@PathVariable(name = "id") Long id) {
        return enginRessources.getEngin(id);
    }

    @PostMapping("/engin/save")
    public Engin saveEngin(@RequestBody Engin engin) {
        return enginRessources.saveEngin(engin);
    }

    @DeleteMapping("/engin/delete/{id}")
    public void deleteEngin(@PathVariable(name = "id") Long id) {
        enginRessources.deleteEngin(id);
    }
}
