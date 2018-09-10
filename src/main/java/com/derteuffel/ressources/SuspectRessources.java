package com.derteuffel.ressources;

import com.derteuffel.dao.SuspectRepository;
import com.derteuffel.entities.Suspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 02/09/2018.
 */


@Service
public class SuspectRessources {

    @Autowired
    private SuspectRepository suspectRepository;

    public Page<Suspect> findByDepartement(String departement, Pageable pageable) {
        return suspectRepository.findByDepartement(departement, pageable);
    }

    public Page<Suspect> findBySituation(String situation, Pageable pageable) {
        return suspectRepository.findBySituation(situation, pageable);
    }

    public Page<Suspect> findByStatus(String status, Pageable pageable) {
        return suspectRepository.findByStatus(status, pageable);
    }


    /* public List<Suspect> findBySituation(String situation) {
        Iterable<Suspect> suspects=suspectRepository.findAll();
        List<Suspect> result= new ArrayList<>();
        for (Suspect suspect:suspects) {
            if (suspect.getSituation().equalsIgnoreCase("liberer")) {
                result.add(suspect);
            }else if (suspect.getSituation().equalsIgnoreCase("deferer")){
                result.add(suspect);
            }else if (suspect.getSituation().equalsIgnoreCase("evader")){
                result.add(suspect);
            }
        }
        return result;
    }



    public List<Suspect> findByDepartement(String departement) {
        Iterable<Suspect> suspects=suspectRepository.findAll();
        List<Suspect> result= new ArrayList<>();
        for (Suspect suspect:suspects) {
            if (suspect.getDepartement().equalsIgnoreCase(departement)) {
                result.add(suspect);
            }

        }
        return result;
    }*/

    public Page<Suspect> findAll(Pageable pageable) {
        return suspectRepository.findAll(pageable);
    }

  /*  public List<Suspect> findByStatus(String status) {

        Iterable<Suspect> suspects=suspectRepository.findAll();
        List<Suspect> result= new ArrayList<>();
        for (Suspect suspect:suspects) {
            if (suspect.getStatus().equalsIgnoreCase("detenus")) {
                result.add(suspect);
            }else if (suspect.getStatus().equalsIgnoreCase("libre")){
                result.add(suspect);
            }
        }
        return result;

    }*/

    public Suspect save(Suspect suspect) {
        return suspectRepository.save(suspect);
    }

    public Suspect findById(Long id) {

        Optional<Suspect> suspectOptional=suspectRepository.findById(id);


        return suspectOptional.get();
    }



    public void deleteById(Long id) {
        suspectRepository.deleteById(id);
    }
}
