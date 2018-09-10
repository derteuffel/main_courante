package com.derteuffel.model;

import com.derteuffel.entities.Autre_Materiel;
import com.derteuffel.ressources.Autre_MaterielRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Controller
public class Autre_MaterielModel {



    @Autowired
    private Autre_MaterielRessources autre_materielRessources;

    @GetMapping("/autre_materiels/get")
    public String   getAllAutre_materiel(Model model,  @RequestParam(defaultValue = "0")int page) {
        model.addAttribute("autre_materiels",autre_materielRessources.getAllAutre_Materiel(new PageRequest(page,5)) );
        model.addAttribute("currentPage", page);
        return "autre_materiel/list";
    }

    @GetMapping("/autre_materiels/get/{id}")
    public String getAutre_materiel(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("autre_materiel", autre_materielRessources.getAutre_Materiel(id));
        return "autre_materiel/view";
    }

    @GetMapping("/autre_materiels/form")
    public String autre_materielEditForm(Model model){

            model.addAttribute("autre_materiel", new Autre_Materiel());

        return "autre_materiel/edit";
    }

    @PostMapping("/autre_materiels/save")
    public String saveAutre_materiel( Autre_Materiel autre_materiel) {
        autre_materielRessources.saveAutre_Materiel(autre_materiel);

        return "redirect:/autre_materiels/get";
    }

    @GetMapping("/autre_materiels/delete/{id}")
    public String autre_materielDelete(@PathVariable(required = true, name = "id") Long id){

        autre_materielRessources.deleteAutre_Materiel(id);

        return "redirect:/autre_materiels/get";
    }


}
