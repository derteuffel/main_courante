package com.derteuffel.model;

import com.derteuffel.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Controller
public class SuspectModel {


/*
    @Autowired
    private SuspectRessources suspectRessources;

    @GetMapping("/suspects/get")
    public String getAllSuspect(Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("suspects",suspectRessources.findAll(new PageRequest(page,5)) );
        model.addAttribute("currenPage",page);
        return "suspect/list";
    }


    @GetMapping("/suspects/get/stat/{status}")
    public String findByStatus(@PathVariable(name = "status") String status, Model model, @RequestParam(defaultValue = "0") int page) {

        model.addAttribute("suspects",suspectRessources.findByStatus(status, new PageRequest(page,5)));
        model.addAttribute("currentPage",page);
        return "suspect/list";
    }

    @GetMapping("/suspect/form, /suspect/form/{id}")
    public String suspectEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
        if (id != null){
            model.addAttribute("suspect", suspectRessources.findById(id));
        }else {
            model.addAttribute("suspect", new Suspect());
        }
        return "suspect/edit";
    }
    @PostMapping("/suspects/save")
    public String save(Suspect suspect) {
        suspectRessources.save(suspect);


        return "redirect:/suspects/get";
    }


    @GetMapping("/suspects/delete/{id}")
    public String deleteSuspect(@PathVariable(name = "id") Long id) {
        suspectRessources.deleteById(id);
        return "redirect:/suspects/get";
    }

    @GetMapping("/suspects/get/dept/{departement}")
    public String findByDepartement(@PathVariable(name = "departement") String departement, Model model, @RequestParam("0") int page) {
        model.addAttribute("suspects", suspectRessources.findByDepartement(departement, new PageRequest(page, 5)));
        model.addAttribute("currentPage", page);

        return "suspect/list";
    }

    @GetMapping("/suspects/get/sit/{situation}")
    public String getAllBySituation(@PathVariable(name = "situation") String situation, Model model,@RequestParam(defaultValue = "0") int page) {

        model.addAttribute("suspects", suspectRessources.findBySituation(situation, new PageRequest(page,5)));
        model.addAttribute("currentPage", page);
        return"suspect/list";
    }

    @GetMapping("/suspects/get/{id}")
    public String getSuspect(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("suspect", suspectRessources.findById(id));
        return "suspect/view";
    }*/
}
