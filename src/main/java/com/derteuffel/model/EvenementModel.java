package com.derteuffel.model;

import com.derteuffel.dao.EquipeRepository;
import com.derteuffel.dao.EvenementRepository;
import com.derteuffel.entities.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Controller
public class EvenementModel {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private EquipeRepository equipeRepository;


    @GetMapping("/evenements/user/{id}")
    public String findByUser(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("evenements", evenementRepository.findAllByUsers_Id(id));
        return "user/evenement/list";
    }

    @GetMapping("/evenements/nature/{nature}")
    public String findByNature(@PathVariable(name = "nature") String nature, Model model) {

        model.addAttribute("evenements", evenementRepository.findAllByNature(nature));
        return "evenement/list";
    }

    @GetMapping("/evenements/form")
    public String evenementEditForm(Model model){

            model.addAttribute("equipes", equipeRepository.findAll());
            model.addAttribute("evenement", new Evenement());
        return "evenement/edit";
    }

    @PostMapping("/evenements/save")
    public String save( Evenement evenement) {

         evenementRepository.save(evenement);

        return "redirect/evenements/get";
    }

    @GetMapping("/evenements/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {
        evenementRepository.deleteById(id);
        return "redirect:/evenements/get";
    }

    @GetMapping("/evenements/saisine/{saisine}")
    public String findBySaisine(@PathVariable(name = "saisine") String saisine, Model model) {

        model.addAttribute("evenements", evenementRepository.findAllBySaisine(saisine));

        return "evenement/list";
    }

    @GetMapping("/evenements/get/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {
        model.addAttribute("evenement", evenementRepository.getOne(id));
        return "evenement/view";
    }

    @GetMapping("/evenements/equipe/{id}")
    public String findByEquipe(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("evenements", evenementRepository.getOne(id));
        return "evenement/equipe/list";
    }

    @GetMapping("/evenements/get")
    public String findAll(Model model) {

        model.addAttribute("evenements", evenementRepository.findAll(Sort.by(Sort.Direction.DESC,"id")));
        return "evenement/list";
    }

}
