package com.derteuffel.model;

import com.derteuffel.dao.Autre_MaterielRepository;
import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Autre_Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Controller
public class Autre_MaterielModel {



    @Autowired
    private Autre_MaterielRepository autre_materielRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping("/autre_materiels/get")
    public String   getAllAutre_materiel(Model model) {
        model.addAttribute("autre_materiels",autre_materielRepository.findAll(Sort.by(Sort.Direction.DESC,"id")) );
        return "autre_materiel/list";
    }

    @GetMapping("/autre_materiels/get/{id}")
    public String getAutre_materiel(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("autre_materiel",autre_materielRepository.getOne(id));
        return "autre_materiel/view";
    }

    @GetMapping("/autre_materiels/form")
    public String autre_materielEditForm(Model model){

            model.addAttribute("autre_materiel", new Autre_Materiel());

        return "autre_materiel/edit";
    }

    @PostMapping("/autre_materiels/save")
    public String saveAutre_materiel(Autre_Materiel autre_materiel, RedirectAttributes redirectAttributes) {
        autre_materiel.setType_autre("BALLAIS");
        autre_materiel.setType("AUTRE");
        autre_materiel.setStatus("EN SERVICE");
        autre_materielRepository.save(autre_materiel);
        redirectAttributes.addFlashAttribute("success","Votre ajout a ete fait avec succes");

        return "redirect:/autre_materiels/get";
    }

    @GetMapping("/autre_materiels/edit/{id}")
    public String form(Model model, @PathVariable Long id){

        model.addAttribute("users", personnelRepository.findAll());
        model.addAttribute("autre_materiel", autre_materielRepository.getOne(id));

        return "autre_materiel/update";
    }

    @PostMapping("/autre_materiels/update")
    public String updateAutre_materiel(Autre_Materiel autre_materiel, RedirectAttributes redirectAttributes) {
        autre_materiel.setType_autre("BALLAIS");
        autre_materiel.setType("AUTRE");
        autre_materiel.setStatus("EN SERVICE");
        autre_materielRepository.save(autre_materiel);
        redirectAttributes.addFlashAttribute("success","Votre mise a jour a ete fait avec succes");

        return "redirect:/autre_materiels/get";
    }

    @GetMapping("/autre_materiels/delete/{id}")
    public String autre_materielDelete(@PathVariable(required = true, name = "id") Long id){

        autre_materielRepository.deleteById(id
        );

        return "redirect:/autre_materiels/get";
    }


}
