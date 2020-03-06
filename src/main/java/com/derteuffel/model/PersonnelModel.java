package com.derteuffel.model;

import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by derteuffel on 30/08/2018.
 */
@Controller
public class PersonnelModel {

    @Value("${file.upload-dir}")
    private String fileStorage;

   @Autowired
    private PersonnelRepository personnelRepository;

    @GetMapping("/personnels/get")
    public String personnelList(Model model){
        model.addAttribute("personnels", personnelRepository.findAll(Sort.by(Sort.Direction.DESC,"id")));
        return "personnel/list";
    }


    @GetMapping("/personnels/form")
    public String personnelForm(Model model){

            model.addAttribute("personnel", new Personnel());
        return "personnel/edit";
    }

    @GetMapping("/personnels/edit/{id}")
    public String personnelEditForm(Model model, @PathVariable(required = false, name = "id") Long id){
            model.addAttribute("personnel", personnelRepository.getOne(id));

        return "personnel/update";
    }

    @PostMapping("/personnels/save")
    public String personnelSaveAndEdit(Personnel personnel, RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file){

        Personnel personnel1 = personnelRepository.findByMatricule(personnel.getMatricule());
        if (personnel1 != null){
            redirectAttributes.addFlashAttribute("error","il existe deja un personnel avec ce matricule");
            return "redirect:/personnels/form";
        }else {
            if (!(file.isEmpty())) {
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(fileStorage + file.getOriginalFilename());
                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                personnel.setAvatar("/downloadFile/" + file.getOriginalFilename());
            } else {
                personnel.setAvatar("/images/icon/avatar-01.jpg");

            }
            personnel.setStatus("EN SERVICE");
            personnelRepository.save(personnel);
            redirectAttributes.addFlashAttribute("success", "Votre ajout a ete fait avec succes");
            return "redirect:/personnels/get";
        }
    }

    @PostMapping("/personnels/update")
    public String personnelEdit(Personnel personnel, RedirectAttributes redirectAttributes, @RequestParam("file") MultipartFile file){

            if (!(file.isEmpty())) {
                try {
                    byte[] bytes = file.getBytes();
                    Path path = Paths.get(fileStorage + file.getOriginalFilename());
                    Files.write(path, bytes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                personnel.setAvatar("/downloadFile/" + file.getOriginalFilename());
            } else {
                personnel.setAvatar(personnel.getAvatar());

            }
            personnel.setStatus("EN SERVICE");
            personnelRepository.save(personnel);
            redirectAttributes.addFlashAttribute("success", "Votre mise a jour a ete faite avec succes");
            return "redirect:/personnels/get";

    }

    @GetMapping("/personnels/delete/{id}")
    public String personnelDelete(@PathVariable(required = true, name = "id") Long id){

        personnelRepository.deleteById(id);

        return "redirect:/personnels/get";
    }

    @GetMapping("/personnels/status/{status}")
    public String personnelGetByStatus(Model model, @PathVariable(required = true, name = "status") String status){
        model.addAttribute("personnels", personnelRepository.findAllByStatus(status));
        return "personnel/list";
    }


    @GetMapping("/personnels/get/{id}")
    public String personnelShow(Model model, @PathVariable(required = true, name = "id") Long id){

        model.addAttribute("personnel", personnelRepository.getOne(id));
        return "personnel/view";
    }


}
