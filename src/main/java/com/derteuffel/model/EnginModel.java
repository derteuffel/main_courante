package com.derteuffel.model;

import com.derteuffel.dao.EnginRepository;
import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Engin;
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
public class EnginModel {

    @Autowired
    private EnginRepository enginRepository;

    @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping("/engins/get")
    public String   getAllEngin(Model model) {
        model.addAttribute("engins",enginRepository.findAll(Sort.by(Sort.Direction.DESC,"id")) );
        return "engin/list";
    }

    @GetMapping("/engins/get/{id}")
    public String getEngin(Model model, @PathVariable(name = "id") Long id) {
        model.addAttribute("engin",enginRepository.getOne(id));
        return "engin/view";
    }

    @GetMapping("/engins/form")
    public String aenginEditForm(Model model){

        model.addAttribute("engin", new Engin());

        return "engin/edit";
    }

    @PostMapping("/engins/save")
    public String saveEngin(Engin engin, RedirectAttributes redirectAttributes) {
        engin.setType("ENGIN");
        engin.setStatus("EN SERVICE");
        enginRepository.save(engin);
        redirectAttributes.addFlashAttribute("success","Votre ajout a ete fait avec succes");

        return "redirect:/engins/get";
    }

    @GetMapping("/engins/edit/{id}")
    public String form(Model model, @PathVariable Long id){

        model.addAttribute("users", personnelRepository.findAll());
        model.addAttribute("engin", enginRepository.getOne(id));

        return "engin/update";
    }

    @PostMapping("/engins/update")
    public String updateEngin(Engin engin, RedirectAttributes redirectAttributes) {
        engin.setType("ENGIN");
        engin.setStatus("EN SERVICE");
        enginRepository.save(engin);
        redirectAttributes.addFlashAttribute("success","Votre mise a jour a ete fait avec succes");

        return "redirect:/engins/get";
    }

    @GetMapping("/engins/delete/{id}")
    public String delete(@PathVariable(required = true, name = "id") Long id){

        enginRepository
                .deleteById(id
        );

        return "redirect:/engins/get";
    }

}
