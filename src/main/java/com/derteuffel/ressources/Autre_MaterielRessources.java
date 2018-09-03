package com.derteuffel.ressources;

import com.derteuffel.dao.Autre_MaterielRepository;
import com.derteuffel.entities.Autre_Materiel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Service
public class Autre_MaterielRessources {


    @Autowired
    private Autre_MaterielRepository autre_materielRepository;


    public List<Autre_Materiel> getAllAutre_Materiel(){
        return autre_materielRepository.findAll();
    }
    public Autre_Materiel getAutre_Materiel(Long id){
        Optional<Autre_Materiel> autre_materielOptional=autre_materielRepository.findById(id);
        return autre_materielOptional.get();
    }

    public Autre_Materiel saveAutre_Materiel(Autre_Materiel autre_materiel){
        return autre_materielRepository.save(autre_materiel);
    }

    public void deleteAutre_Materiel(Long id){

        autre_materielRepository.deleteById(id);
    }
}
