package com.derteuffel.model;

import com.derteuffel.entities.Personnel;
import com.derteuffel.ressources.PersonelRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by derteuffel on 30/08/2018.
 */
@Controller
public class PersonnelModel {

    @Autowired
    private PersonelRessources personelRessources;

    @GetMapping("/personnels/get")
    public String personnelList(Model model){
        model.addAttribute("personnels", personelRessources.getAllPersonnel());
        return "personnel/list";
    }


    @GetMapping("/personnels/form, /personnels/form/{id}")
    public String personnelEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
        if (id != null){
            model.addAttribute("personnel", personelRessources.getPersonel(id));
        }else {
            model.addAttribute("personnel", new Personnel());
        }
        return "personnel/edit";
    }

    @PostMapping("/personnels/save")
    public String personnelSaveAndEdit(Model model, @RequestBody Personnel personnel){
        personelRessources.addPersonnel(personnel);

        model.addAttribute("personnels", personelRessources.getAllPersonnel());

        return "personnel/list";
    }

    @GetMapping("/personnels/delete/{id}")
    public String personnelDelete(Model model, @PathVariable(required = true, name = "id") Long id){

        personelRessources.deletePersonnel(id);

        model.addAttribute("personnels", personelRessources.getAllPersonnel());

        return "personnel/list";
    }

    @GetMapping("/personnels/get/stat/{status}")
    public String personnelGetByStatus(Model model, @PathVariable(required = true, name = "status") String status){
        model.addAttribute("personnels", personelRessources.findByStatus(status));

        return "personnel/list";
    }


    @GetMapping("/personnels/get/{id}")
    public String personnelShow(Model model, @PathVariable(required = true, name = "id") Long id){

        model.addAttribute("personnel", personelRessources.getPersonel(id));
        return "personnel/view";
    }

}
