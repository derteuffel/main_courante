package com.derteuffel.model;

import com.derteuffel.entities.Engin;
import com.derteuffel.ressources.EnginRessources;
import org.springframework.beans.factory.annotation.Autowired;
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
public class EnginModel {


    @Autowired
    private EnginRessources enginRessources;


    @GetMapping("/engins/get")
    public String   getAllEngin(Model model) {
        model.addAttribute("engins",enginRessources.getAllEngin() );
        return "engin/list";
    }

    @GetMapping("/engins/get/{id}")
    public String getEngin(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("engin", enginRessources.getEngin(id));
        return "engin/view";
    }

    @GetMapping("/engins/form")
    public String enginForm(Model model){

            model.addAttribute("engin", new Engin());
        return "engin/edit";
    }

    @PostMapping("/engins/save")
    public String saveEngin( Engin engin, Model model) {
        model.addAttribute("engins", enginRessources.getAllEngin());
        return "engin/list";
    }

    @GetMapping("/engins/delete/{id}")
    public String enginDelete(Model model, @PathVariable(required = true, name = "id") Long id){

        enginRessources.deleteEngin(id);

        model.addAttribute("engins", enginRessources.getAllEngin());

        return "engin/list";
    }

}
