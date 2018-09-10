package com.derteuffel.model;

import com.derteuffel.entities.Engin;
import com.derteuffel.ressources.EnginRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Controller
public class EnginModel {


    @Autowired
    private EnginRessources enginRessources;


    @GetMapping("/engins/get")
    public String   getAllEngin(Model model, @RequestParam(defaultValue = "0") int page) {
        model.addAttribute("engins",enginRessources.getAllEngin(new PageRequest(page,5)) );
        model.addAttribute("currentPage",page);
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
    public String saveEngin( Engin engin) {
       enginRessources.saveEngin(engin);
        return "redirect:/engins/get";
    }

    @GetMapping("/engins/delete/{id}")
    public String enginDelete(@PathVariable(required = true, name = "id") Long id){

        enginRessources.deleteEngin(id);

        return "redirect:/engins/get";
    }

}
