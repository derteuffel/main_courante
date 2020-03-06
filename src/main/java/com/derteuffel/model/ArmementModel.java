package com.derteuffel.model;

import com.derteuffel.dao.ArmementRepository;
import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Armement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class ArmementModel {

    @Autowired
    private ArmementRepository armementRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping("/armements/get")
    public String   getAllArmement(Model model) {

        model.addAttribute("users",personnelRepository.findAll());

        model.addAttribute("armements", armementRepository.findAll(Sort.by(Sort.Direction.DESC,"id")));
        return "armement/list";
    }

    @GetMapping("/armements/user/{id}")
    public String findByuser(Model model, @PathVariable Long id){
        model.addAttribute("armements", armementRepository.findAllByUser_Id(id));
        return "armement/list";
    }

    @GetMapping("/armements/get/{id}")
    public String getArmement(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("armement", armementRepository.getOne(id));
        return "armement/view";
    }

    @GetMapping("/armements/form")
    public String armementEditForm(Model model){

            model.addAttribute("armement", new Armement());
        return "armement/edit";
    }

    @GetMapping("/armements/edit/{id}")
    public String form(Model model, @PathVariable Long id){

        model.addAttribute("users", personnelRepository.findAll());
        model.addAttribute("armement", armementRepository.getOne(id));
        return "armement/update";
    }

    @PostMapping("/armements/save")
    public String saveArmement(Armement armement, RedirectAttributes redirectAttributes) {
        armement.setType("ARMEMENT");
        armement.setStatus("EN SERVICE");
        armementRepository.save(armement);
        redirectAttributes.addFlashAttribute("success","Votre ajout a ete fait avec succes");
        return "redirect:/armements/get";
    }

    @PostMapping("/armements/update")
    public String updateArmement(Armement armement, RedirectAttributes redirectAttributes) {
        armement.setType("ARMEMENT");
        armement.setStatus("EN SERVICE");
        armementRepository.save(armement);
        redirectAttributes.addFlashAttribute("success","Votre mise a jours a ete fait avec succes");
        return "redirect:/armements/get";
    }

    @GetMapping("/armements/delete/{id}")
    public String armementDelete( @PathVariable(required = true, name = "id") Long id){

        armementRepository.deleteById(id);
        return "redirect:/armements/get";
    }



}
