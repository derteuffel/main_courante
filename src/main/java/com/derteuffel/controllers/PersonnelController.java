package com.derteuffel.controllers;

import com.derteuffel.entities.Personnel;
import com.derteuffel.ressources.PersonelRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 30/08/2018.
 */

@Controller
@RequestMapping("/api")
public class PersonnelController {

    @Autowired
    private PersonelRessources personelRessources;


    @GetMapping("/personnel/{id}")
    public Personnel getPersonel(@PathVariable Long id) {
        return personelRessources.getPersonel(id);
    }

    @DeleteMapping("/personnel/{id}")
    public void deletePersonnel(@PathVariable Long id) {
        personelRessources.deletePersonnel(id);
    }

    @GetMapping("/personnels/{status}")
    public List<Personnel> findByStatus(@PathVariable String status) {
        return personelRessources.findByStatus(status);
    }

    @GetMapping("/personnel")
    public List<Personnel> getAllPersonnel() {
        return personelRessources.getAllPersonnel();
    }

    @PostMapping("/personnel")
    public Personnel addPersonnel(@RequestBody Personnel personnel) {
        return personelRessources.addPersonnel(personnel);
    }

  /*  public ResponseEntity<Object> updatePersonnel(@RequestBody Personnel personnel, @PathVariable Long id) {
        return personelRessources.updatePersonnel(personnel, id);
    }*/
}
