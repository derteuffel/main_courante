package com.derteuffel.model;

import com.derteuffel.entities.Suspect;
import com.derteuffel.ressources.SuspectRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Controller
public class SuspectModel {



    @Autowired
    private SuspectRessources suspectRessources;

    @GetMapping("/suspects/get")
    public String getAllSuspect(Model model) {

        model.addAttribute("suspects",suspectRessources.findAll() );
        return "suspect/list";
    }


    @GetMapping("/suspects/get/stat/{status}")
    public String findByStatus(@PathVariable(name = "status") String status, Model model) {

        model.addAttribute("suspects",suspectRessources.findByStatus(status));
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
    public String save(Model model, Suspect suspect) {
        suspectRessources.save(suspect);
        model.addAttribute("suspects", suspectRessources.findAll());

        return "suspect/list";
    }


    @GetMapping("/suspects/delete/{id}")
    public String deleteSuspect(@PathVariable(name = "id") Long id, Model model) {
        suspectRessources.deleteById(id);

        model.addAttribute("suspects", suspectRessources.findAll());
        return "suspect/list";
    }

    @GetMapping("/suspects/get/dept/{departement}")
    public String findByDepartement(@PathVariable(name = "departement") String departement, Model model) {
        model.addAttribute("suspects", suspectRessources.findByDepartement(departement));

        return "suspect/list";
    }

    @GetMapping("/suspects/get/sit/{situation}")
    public String getAllBySituation(@PathVariable(name = "situation") String situation, Model model) {

        model.addAttribute("suspects", suspectRessources.findBySituation(situation));

        return"suspect/list";
    }

    @GetMapping("/suspects/get/{id}")
    public String getSuspect(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("suspect", suspectRessources.findById(id));
        return "suspect/view";
    }
}
