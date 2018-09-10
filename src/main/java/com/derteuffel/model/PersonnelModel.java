package com.derteuffel.model;

import com.derteuffel.entities.Personnel;
import com.derteuffel.ressources.PersonelRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
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
    public String personnelList(Model model, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("personnels", personelRessources.getAllPersonnel(new PageRequest(page,5)));
        model.addAttribute("currentPage",page);
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
    public String personnelSaveAndEdit(Personnel personnel){
        personelRessources.addPersonnel(personnel);


        return "redirect:/personnels/get";
    }

    @GetMapping("/personnels/delete/{id}")
    public String personnelDelete(@PathVariable(required = true, name = "id") Long id){

        personelRessources.deletePersonnel(id);

        return "redirect:/personnels/get";
    }

    @GetMapping("/personnels/get/stat/{status}")
    public String personnelGetByStatus(Model model, @PathVariable(required = true, name = "status") String status, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("personnels", personelRessources.findByStatus(status, new PageRequest(page, 5)));
        model.addAttribute("currentPage",page);
        return "personnel/list";
    }


    @GetMapping("/personnels/get/{id}")
    public String personnelShow(Model model, @PathVariable(required = true, name = "id") Long id){

        model.addAttribute("personnel", personelRessources.getPersonel(id));
        return "personnel/view";
    }

}
