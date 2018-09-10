package com.derteuffel.model;

import com.derteuffel.entities.Armement;
import com.derteuffel.ressources.ArmementRessources;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Controller
public class ArmementModel {

    @Autowired
    private ArmementRessources armementRessources;

    @GetMapping("/armements/get")
    public String   getAllArmement(Model model,@RequestParam(defaultValue = "0")int page) {

        Page<Armement> armements = armementRessources.getAllArmement(new PageRequest(page,5));

        model.addAttribute("armements", armements);
        model.addAttribute("currentPage", page);
        return "armement/list";
    }

    public String findByuser(Model model, @PathVariable String type, @RequestParam(defaultValue = "0") int page){
        model.addAttribute("armements", armementRessources.findByUser(type,new PageRequest(page,5)));
        model.addAttribute("currentPage",page);
        return "user/armement/list";
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
    public String saveArmement(Armement armement) {
        armementRessources.saveArmement(armement);
        return "redirect:/armements/get";
    }

    @GetMapping("/armements/delete/{id}")
    public String armementDelete( @PathVariable(required = true, name = "id") Long id){

        armementRessources.deleteArmement(id);

        return "redirect:/armements/get";
    }



}
