package com.derteuffel.ressources;

import com.derteuffel.dao.EquipeRepository;
import com.derteuffel.dao.EvenementRepository;
import com.derteuffel.entities.Equipe;
import com.derteuffel.entities.Evenement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by derteuffel on 03/09/2018.
 */

@Service
public class EquipeRessources {

    @Autowired
    private EquipeRepository equipeRepository;

    @Autowired
    private EvenementRepository evenementRepository;

   /* public Equipe findByEvenements(Long id) {
        Optional<Evenement> evenementOptional= evenementRepository.findById(id);

        Equipe equipe= evenementOptional.get().getEquipe();

        return equipe;
    }*/

    public List<Equipe> findAll() {
        return equipeRepository.findAll();
    }

    public Equipe save(Equipe equipe) {
        return equipeRepository.save(equipe);
    }

    public Equipe findById(Long id) {

        Optional<Equipe> equipeOptional=equipeRepository.findById(id);

        return equipeOptional.get();
    }

    public void deleteById(Long id) {
        equipeRepository.deleteById(id);
    }
}
