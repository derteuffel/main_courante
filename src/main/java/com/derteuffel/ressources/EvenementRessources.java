package com.derteuffel.ressources;

import com.derteuffel.dao.EvenementRepository;
import com.derteuffel.dao.PersonnelRepository;
import com.derteuffel.dao.UserRepository;
import com.derteuffel.entities.Evenement;
import com.derteuffel.entities.Personnel;
import com.derteuffel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * Created by derteuffel on 02/09/2018.
 */
@Service
public class EvenementRessources {

    @Autowired
    private EvenementRepository evenementRepository;

    @Autowired
    private UserRepository userRepository;

    public Set<Evenement> findByUser(Long id) {

        Optional<User> userOptional= userRepository.findById(id);
        Set<Evenement> evenements=userOptional.get().getEvenements();

        return evenements;

    }

    public List<Evenement> findBySaisine(String saisine) {

        List<Evenement> evenements=evenementRepository.findAll();
        List<Evenement> result=new ArrayList<>();

        for (Evenement evenement:evenements){
            if (evenement.getSaisine().equalsIgnoreCase(saisine)){
                result.add(evenement);
            }
        }
        return result;
    }

    public Evenement findById(Long id) {
        Optional<Evenement> evenementOptional= evenementRepository.findById(id);

        return  evenementOptional.get();
    }

    public List<Evenement> findByEquipe(Long id) {
        List<Evenement> evenements=evenementRepository.findAll();
        List<Evenement> result=new ArrayList<>();

        for (Evenement evenement:evenements){
            if (evenement.getEquipe().getId().equals(id)){
                result.add(evenement);
            }
        }
        return result;

    }

    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }

    public List<Evenement> findByNature(String nature) {
        List<Evenement> evenements=evenementRepository.findAll();
        List<Evenement> result=new ArrayList<>();

        for (Evenement evenement:evenements){
            if (evenement.getN_ordre().equalsIgnoreCase(nature)){
                result.add(evenement);
            }
        }
        return result;
    }

    public Evenement save(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public List<Evenement> findAll() {
        return evenementRepository.findAll();
    }
}
