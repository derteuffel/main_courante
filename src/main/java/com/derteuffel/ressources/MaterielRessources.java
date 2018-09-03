package com.derteuffel.ressources;

import com.derteuffel.dao.MaterielRepository;
import com.derteuffel.entities.Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 31/08/2018.
 */

@Service
public class MaterielRessources {


    @Autowired
    private MaterielRepository materielRepository;


    public List<Materiel> getAllMateriel(){
        return materielRepository.findAll();
    }


    public List<Materiel> findByType(String type){
        Iterable<Materiel> materiels=materielRepository.findAll();
        List<Materiel> result= new ArrayList<>();
        for (Materiel materiel:materiels) {
            if (materiel.getType().equalsIgnoreCase(type)) {
                result.add(materiel);
            }
        }
        return result;
    }

    public List<Materiel> findByStarus(String status){
        Iterable<Materiel> materiels=materielRepository.findAll();
        List<Materiel> result= new ArrayList<>();
        for (Materiel materiel:materiels) {
            if (materiel.getStatus().equalsIgnoreCase("decharger")) {
                result.add(materiel);
            }else if (materiel.getStatus().equalsIgnoreCase("stocker")){
                result.add(materiel);
            }
        }
        return result;
    }


    public Materiel getMateriel(Long id){

        Optional<Materiel> materielOptional=materielRepository.findById(id);

        return materielOptional.get();
    }

    public Materiel saveMateriel(Materiel materiel){

        return materielRepository.save(materiel);
    }


    public void deleteMateriel(Long id){

        materielRepository.deleteById(id);
    }
}
