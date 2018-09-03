package com.derteuffel.ressources;

import com.derteuffel.dao.EnginRepository;
import com.derteuffel.entities.Engin;
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
public class EnginRessources {


    @Autowired
    private EnginRepository enginRepository;

    public List<Engin> getAllEngin(){
        return enginRepository.findAll();
    }
    public Engin getEngin(Long id){
        Optional<Engin> enginOptional=enginRepository.findById(id);
        return enginOptional.get() ;
    }

    public Engin saveEngin(Engin engin){
        return enginRepository.save(engin);
    }

    public void deleteEngin(Long id){

        enginRepository.deleteById(id);
    }
}
