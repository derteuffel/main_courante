package com.derteuffel.model;

import com.derteuffel.entities.Armement;
import com.derteuffel.ressources.ArmementRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Controller
public class ArmementModel {

    @Autowired
    private ArmementRessources armementRessources;

    @GetMapping("/armements/get")
    public String   getAllArmement(Model model) {
        model.addAttribute("armements",armementRessources.getAllArmement() );
        return "armement/list";
    }

    @GetMapping("/armements/get/{id}")
    public String getArmement(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("armement", armementRessources.getArmement(id));
        return "armement/view";
    }

    @GetMapping("/armements/form")
    public String armementEditForm(Model model){

            model.addAttribute("armement", new Armement());
        return "armement/edit";
    }

    @PostMapping("/armements/save")
    public String saveArmement(@RequestBody Armement armement, Model model) {
        model.addAttribute("armements", armementRessources.getAllArmement());
        return "armement/list";
    }

    @GetMapping("/armements/delete/{id}")
    public String armementDelete(Model model, @PathVariable(required = true, name = "id") Long id){

        armementRessources.deleteArmement(id);

        model.addAttribute("armements", armementRessources.getAllArmement());

        return "armement/list";
    }



}
