package com.derteuffel.ressources;

import com.derteuffel.dao.ArmementRepository;
import com.derteuffel.entities.Armement;
import com.derteuffel.entities.Personnel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 01/09/2018.
 */

@Service
public class ArmementRessources {


    @Autowired
    private ArmementRepository armementRepository;

   public Page<Armement> getAllArmement(Pageable pageable){
       return armementRepository.findAll(pageable);

   }

    @Query("select a from Armement a where a.user.type=:type")
    public Page<Armement> findByUser(@Param("type") String type, Pageable pageable) {
        return armementRepository.findByUser(type, pageable);
    }

    public Armement getArmement(Long id){
        Optional<Armement> armementOptional=armementRepository.findById(id);
        return armementOptional.get();
    }

    public Armement saveArmement(Armement armement){
        return armementRepository.save(armement);
    }

    public void deleteArmement(Long id){

        armementRepository.deleteById(id);
    }
}
