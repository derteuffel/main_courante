package com.derteuffel.model;

import com.derteuffel.entities.Materiel;
import com.derteuffel.ressources.MaterielRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by derteuffel on 31/08/2018.
 */

@Controller
public class MaterielModel {


    @Autowired
    private MaterielRessources materielRessources;


    @GetMapping("/materiels/get")
    public String materielList(Model model){
        model.addAttribute("mateirels",materielRessources.getAllMateriel());
        return "materiel/list";
    }






    @GetMapping("/materiels/get/type/{type}")
    public String materielGetByType(Model model, @PathVariable(required = true, name = "status") String type){
        model.addAttribute("materiels", materielRessources.findByType(type));

        return "materiel/list";
    }


    @GetMapping("/materiels/get/{id}")
    public String materielShow(Model model, @PathVariable(required = true, name = "id") Long id){

        model.addAttribute("materiel", materielRessources.getMateriel(id));
        return "materiel/view";
    }


    @GetMapping("/materiels/delete/{id}")
    public String materielDelete(Model model, @PathVariable(required = true, name = "id") Long id){

 materielRessources.deleteMateriel(id);
        model.addAttribute("materiels", materielRessources.getAllMateriel());

        return "materiel/list";
    }

    @GetMapping("/materiels/get/stat/{status}")
    public String materielGetByStatus(Model model, @PathVariable(required = true, name = "status") String status){
        model.addAttribute("materiels", materielRessources.findByStarus(status));

        return "materiel/list";
    }

}
