package com.derteuffel.model;

import com.derteuffel.entities.Autre_Materiel;
import com.derteuffel.ressources.Autre_MaterielRessources;
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
public class Autre_MaterielModel {



    @Autowired
    private Autre_MaterielRessources autre_materielRessources;

    @GetMapping("/autre_materiels/get")
    public String   getAllAutre_materiel(Model model) {
        model.addAttribute("autre_materiels",autre_materielRessources.getAllAutre_Materiel() );
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
    public String saveAutre_materiel(@RequestBody Autre_Materiel autre_materiel, Model model) {
        model.addAttribute("autre_materiels", autre_materielRessources.getAllAutre_Materiel());
        return "autre_materiel/list";
    }

    @GetMapping("/autre_materiels/delete/{id}")
    public String autre_materielDelete(Model model, @PathVariable(required = true, name = "id") Long id){

        autre_materielRessources.deleteAutre_Materiel(id);

        model.addAttribute("autre_materiels", autre_materielRessources.getAllAutre_Materiel());

        return "autre_materiel/list";
    }


}
