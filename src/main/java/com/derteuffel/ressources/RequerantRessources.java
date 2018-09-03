package com.derteuffel.ressources;

import com.derteuffel.dao.RequerantRepository;
import com.derteuffel.entities.Requerant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 02/09/2018.
 */

@Service
public class RequerantRessources {

    @Autowired
    private RequerantRepository requerantRepository;


    public List<Requerant> findAll() {
        return requerantRepository.findAll();
    }

    public Requerant save(Requerant requerant) {
        return requerantRepository.save(requerant);
    }

    public Requerant findById(Long id) {

        Optional<Requerant> requerantOptional=requerantRepository.findById(id);
        return requerantOptional.get();
    }

    public void deleteById(Long id) {
        requerantRepository.deleteById(id);
    }
}
