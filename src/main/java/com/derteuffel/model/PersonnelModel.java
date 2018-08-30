package com.derteuffel.model;

import com.derteuffel.entities.Personnel;
import com.derteuffel.ressources.PersonelRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by derteuffel on 30/08/2018.
 */
@Controller
public class PersonnelModel {

    @Autowired
    private PersonelRessources personelRessources;

    @GetMapping("/personnels")
    public String personnelList(Model model){
        model.addAttribute("personnels", personelRessources.getAllPersonnel());
        return "personnel/list";
    }


    @GetMapping("/personnelForm, /personnelForm/{id}")
    public String personnelEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
        if (id != null){
            model.addAttribute("personnel", personelRessources.getPersonel(id));
        }else {
            model.addAttribute("personnel", new Personnel());
        }
        return "personnel/edit";
    }

    @PostMapping("/personnelSave")
    public String personnelSaveAndEdit(Model model, Personnel personnel){
        personelRessources.addPersonnel(personnel);

        model.addAttribute("personnelList", personelRessources.getAllPersonnel());

        return "personnel/list";
    }

    @GetMapping("/personnelDelete/{id}")
    public String personnelDelete(Model model, @PathVariable(required = true, name = "id") Long id){

        personelRessources.deletePersonnel(id);

        model.addAttribute("personnels", personelRessources.getAllPersonnel());

        return "personnel/list";
    }

    @GetMapping("/personnels/{status}")
    public String personnelGetByStatus(Model model, @PathVariable(required = true, name = "status") String status){
        model.addAttribute("personnelList", personelRessources.findByStatus(status));

        return "personnel/list";
    }


    @GetMapping("/personnel/{id}")
    public String personnelShow(Model model, @PathVariable(required = true, name = "id") Long id){

        model.addAttribute("personnel", personelRessources.getPersonel(id));
        return "personnel/view";
    }

}
