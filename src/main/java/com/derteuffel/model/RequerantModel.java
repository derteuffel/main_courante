package com.derteuffel.model;

import com.derteuffel.entities.Requerant;
import com.derteuffel.ressources.RequerantRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Controller
public class RequerantModel {

    @Autowired
    private RequerantRessources requerantRessources;


    @GetMapping("/requerants/get")
    public String getAllRequerant(Model model) {

        model.addAttribute("requerants", requerantRessources.findAll());
        return "requerant/list";
    }


    @GetMapping("/requerants/delete/{id}")
    public String deleteRequerant(@PathVariable(name = "id") Long id, Model model) {
        requerantRessources.deleteById(id);
        model.addAttribute("requerants", requerantRessources.findAll());
        return "requerant/list";
    }


    @GetMapping("/requerants/form, /requerants/form/{id}")
    public String requerantEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
        if (id != null){
            model.addAttribute("requerant", requerantRessources.findById(id));
        }else {
            model.addAttribute("requerant", new Requerant());
        }
        return "requerant/edit";
    }

    @PostMapping("/requerants/save")
    public String saveRequerant(@RequestBody Requerant requerant, Model model) {

        requerantRessources.save(requerant);

        model.addAttribute("requerants", requerantRessources.findAll());

        return "requerant/list";
    }

    @GetMapping("/requerants/get/{id}")
    public String getRequerant(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("requerant", requerantRessources.findById(id));
        return "requerant/list";
    }
}
