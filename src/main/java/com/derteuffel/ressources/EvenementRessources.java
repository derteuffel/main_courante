package com.derteuffel.ressources;

import com.derteuffel.dao.EvenementRepository;
import com.derteuffel.dao.UserRepository;
import com.derteuffel.entities.Evenement;
import com.derteuffel.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


   /* public Set<Evenement> findByUser(Long id, Pageable pageable ) {

        Optional<User> userOptional= userRepository.findById(id);
        Set<Evenement> evenements=userOptional.get().getEvenements();

        return evenements;

    }

    public List<Evenement> findBySaisine(String saisine, Pageable pageable) {

        List<Evenement> evenements=evenementRepository.findAll();
        List<Evenement> result=new ArrayList<>();

        for (Evenement evenement:evenements){
            if (evenement.getSaisine().equalsIgnoreCase(saisine)){
                result.add(evenement);
            }
        }
        return result;
    }*/

    public Evenement findById(Long id) {
        Optional<Evenement> evenementOptional= evenementRepository.findById(id);

        return  evenementOptional.get();
    }

   /* public List<Evenement> findByEquipe(Long id, Pageable pageable) {
        List<Evenement> evenements=evenementRepository.findAll();
        List<Evenement> result=new ArrayList<>();

        for (Evenement evenement:evenements){
            if (evenement.getEquipe().getId().equals(id)){
                result.add(evenement);
            }
        }
        return result;

    }*/

    public void deleteById(Long id) {
        evenementRepository.deleteById(id);
    }

    /*public List<Evenement> findByNature(String nature, Pageable pageable) {
        List<Evenement> evenements=evenementRepository.findAll();
        List<Evenement> result=new ArrayList<>();

        for (Evenement evenement:evenements){
            if (evenement.getN_ordre().equalsIgnoreCase(nature)){
                result.add(evenement);
            }
        }
        return result;
    }*/

    public Evenement save(Evenement evenement) {
        return evenementRepository.save(evenement);
    }

    public Page<Evenement> findAll(Pageable pageable) {
        return evenementRepository.findAll(pageable);
    }

    @Query("select event from Evenement event where event.equipe.id=:id")
    public Page<Evenement> findByEquipe(@Param("id") Long id, Pageable pageable) {
        return evenementRepository.findByEquipe(id, pageable);
    }

    public Page<Evenement> findBySaisine(String saisine, Pageable pageable) {
        return evenementRepository.findBySaisine(saisine, pageable);
    }

    public Page<Evenement> findByNature(String nature, Pageable pageable) {
        return evenementRepository.findByNature(nature, pageable);
    }

    @Query("SELECT event FROM Evenement event join event.users u where  u.id=:id")
    public Page<Evenement> findByUsers(@Param("id") Long id, Pageable pageable) {
        return evenementRepository.findByUsers(id, pageable);
    }
}
