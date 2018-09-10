package com.derteuffel.ressources;

import com.derteuffel.dao.EvenementRepository;
import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.entities.Evenement;
import com.derteuffel.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by derteuffel on 28/08/2018.
 */

@Service
public class PersonelRessources {


    @Autowired
    private PersonnelRepository personnelRepository;

   /* @Autowired
    private EvenementRepository evenementRepository; */


    public Personnel getPersonel(Long id){

        Optional<Personnel> personnel=personnelRepository.findById(id);
        return personnel.get();
    }

    public Page<Personnel> getAllPersonnel(Pageable pageable){

        return personnelRepository.findAll(pageable);
    }


    public Page<Personnel> findByStatus(String status, Pageable pageable){
       return personnelRepository.findByStatus(status,pageable);
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
