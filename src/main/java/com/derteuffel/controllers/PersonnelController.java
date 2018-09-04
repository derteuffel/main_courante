package com.derteuffel.controllers;

import com.derteuffel.entities.Personnel;
import com.derteuffel.ressources.PersonelRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
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


    @GetMapping("/personnels/get/{id}")
    public Personnel getPersonel(@PathVariable Long id) {
        return personelRessources.getPersonel(id);
    }

    @DeleteMapping("/personnels/delete/{id}")
    public void deletePersonnel(@PathVariable Long id) {
        personelRessources.deletePersonnel(id);
    }

    @GetMapping("/personnels/get/{status}")
    public List<Personnel> findByStatus(@PathVariable String status) {
        return personelRessources.findByStatus(status);
    }

    @GetMapping("/personnels/get")
    public Iterable<Personnel> getAllPersonnel() {
        return personelRessources.getAllPersonnel();
    }

    @PostMapping("/personnels/save")
    public Personnel addPersonnel(@RequestBody Personnel personnel) {
        return personelRessources.addPersonnel(personnel);
    }

  /*  public ResponseEntity<Object> updatePersonnel(@RequestBody Personnel personnel, @PathVariable Long id) {
        return personelRessources.updatePersonnel(personnel, id);
    }*/
}
