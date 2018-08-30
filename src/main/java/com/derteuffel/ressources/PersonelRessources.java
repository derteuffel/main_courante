package com.derteuffel.ressources;

import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Personnel;
import com.derteuffel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 28/08/2018.
 */

@Service
public class PersonelRessources {


    @Autowired
    private PersonnelRepository personnelRepository;


    public Personnel getPersonel(Long id){

        Optional<Personnel> personnel=personnelRepository.findById(id);
        return personnel.get();
    }

    public List<Personnel> getAllPersonnel(){

        return personnelRepository.findAll();
    }


    public List<Personnel> findByStatus(String status){
        List<Personnel> personnels=personnelRepository.findAll();
        List<Personnel> result= new ArrayList<>();
        for (Personnel personnel:personnels) {
            if (personnel.getStatus().equalsIgnoreCase(status)) {
                result.add(personnel);
            }
        }
        return result;
        }




    public Personnel addPersonnel(Personnel personnel){


        return personnelRepository.save(personnel);
    }

    public void deletePersonnel( Long id){
        personnelRepository.deleteById(id);
    }



    /*public Personnel updatePersonnel( Personnel personnel, Long id){


        personnel=personnelRepository.getOne(id);


        return  personnelRepository.save(personnel);

    }*/

}
