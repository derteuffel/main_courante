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


    public List<Suspect> getAllSuspect() {
        return suspectRepository.findAll();
    }

    public List<Suspect> getAllByDepartement_d_origine(String departement_d_origine) {

        Iterable<Suspect> suspects=suspectRepository.findAll();
        List<Suspect> result= new ArrayList<>();
        for (Suspect suspect:suspects) {
            if (suspect.getDepartement_d_origine().equalsIgnoreCase(departement_d_origine)) {
                result.add(suspect);
            }

        }
        return result;
    }

    public List<Suspect> getAllBySituation(String situation) {
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

    public List<Suspect> findByStatus(String status) {

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

    }

    public Suspect save(Suspect suspect) {
        return suspectRepository.save(suspect);
    }

    public Suspect getSuspect(Long id) {

        Optional<Suspect> suspectOptional=suspectRepository.findById(id);


        return suspectOptional.get();
    }



    public void deleteSuspect(Long id) {
        suspectRepository.deleteById(id);
    }
}
