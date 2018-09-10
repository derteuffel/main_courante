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


    public Page<Materiel> getAllMateriel(Pageable pageable){
        return materielRepository.findAll(pageable);
    }


    public Page<Materiel> findByType(String type, Pageable pageable){

       return materielRepository.findByType(type,pageable);

    }

    public Page<Materiel> findByStatus(String status, Pageable pageable){
        return materielRepository.findByStatus(status,pageable);
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
