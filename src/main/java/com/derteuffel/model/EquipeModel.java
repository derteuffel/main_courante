package com.derteuffel.model;

import com.derteuffel.dao.EquipeRepository;
import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Equipe;
import com.derteuffel.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Arrays;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Controller
public class EquipeModel {


    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private PersonnelRepository personnelRepository;



    @GetMapping("/equipes/delete/{id}")
    public String deleteById(@PathVariable(name = "id") Long id) {

        equipeRepository.deleteById(id);

        return "redirect:/equipes/get";
    }

    @GetMapping("/equipes/get")
    public String findAll(Model model) {

        model.addAttribute("equipes", equipeRepository.findAll());
        return "equipe/list";
    }

    @GetMapping("/equipes/form")
    public String equipeForm(Model model){
        model.addAttribute("users",personnelRepository.findAll());

            model.addAttribute("equipe", new Equipe());
        return "equipe/edit";
    }

    @GetMapping("/equipes/edit/{id}")
    public String equipeEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
        model.addAttribute("users",personnelRepository.findAll());
            model.addAttribute("equipe", equipeRepository.findById(id));
        return "equipe/edit";
    }

    @PostMapping("/equipes/save")
    public String save(Equipe equipe, RedirectAttributes redirectAttributes) {

        if (!(equipe.getMatricule_chef().isEmpty())){
            Personnel chef = personnelRepository.findByMatricule(equipe.getMatricule_chef());
            equipe.setUsers(Arrays.asList(chef));
        }
        if (!(equipe.getMatricule_chauffeur().isEmpty())){
            Personnel chauffeur = personnelRepository.findByMatricule(equipe.getMatricule_chauffeur());
            equipe.getUsers().add(chauffeur);
        }
        if (!(equipe.getMatricule_secretaire().isEmpty())){
            Personnel secretaire = personnelRepository.findByMatricule(equipe.getMatricule_secretaire());
            equipe.getUsers().add(secretaire);
        }

        if (!(equipe.getMatricule_element().isEmpty())){
            for (String element : equipe.getMatricule_element()){
                equipe.getUsers().add(personnelRepository.findByMatricule(element));
            }
        }

         equipeRepository.save(equipe);
        redirectAttributes.addFlashAttribute("success","Votre ajout a ete fait avec succes");

        return "redirect:/equipes/get";
    }

    @GetMapping("/equipes/get/{id}")
    public String findById(@PathVariable(name = "id") Long id, Model model) {

        model.addAttribute("equipe", equipeRepository.getOne(id));
        return "equipe/view";
    }
}
