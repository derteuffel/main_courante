package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Equipe implements Serializable {


    @Id
    @GeneratedValue
    @Column( updatable = false, nullable = false)
    private Long id;

    @Column
    private String matricule_chef, matricule_chauffeur, matricule_secretaire,nom;

    @Column
    private ArrayList<String> matricule_element = new ArrayList<>();

    //refence of List for Evenemnt objetct

    @OneToMany(mappedBy = "equipe")
    private List<Evenement> evenements;

    @OneToMany(mappedBy = "equipe")
    private List<User> users;

    public Equipe() {
    }


    public Equipe(String matricule_chef, String matricule_chauffeur, String matricule_secretaire,
                  String nom, ArrayList<String> matricule_element, List<Evenement> evenements, List<User> users) {
        this.matricule_chef = matricule_chef;
        this.matricule_chauffeur = matricule_chauffeur;
        this.matricule_secretaire = matricule_secretaire;
        this.nom = nom;
        this.matricule_element = matricule_element;
        this.evenements = evenements;
        this.users = users;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatricule_chef() {
        return matricule_chef;
    }

    public void setMatricule_chef(String matricule_chef) {
        this.matricule_chef = matricule_chef;
    }

    public String getMatricule_chauffeur() {
        return matricule_chauffeur;
    }

    public void setMatricule_chauffeur(String matricule_chauffeur) {
        this.matricule_chauffeur = matricule_chauffeur;
    }

    public String getMatricule_secretaire() {
        return matricule_secretaire;
    }

    public void setMatricule_secretaire(String matricule_secretaire) {
        this.matricule_secretaire = matricule_secretaire;
    }

    public ArrayList<String> getMatricule_element() {
        return matricule_element;
    }

    public void setMatricule_element(ArrayList<String> matricule_element) {

        this.matricule_element = matricule_element;
    }

    public List<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(List<Evenement> evenements) {
        this.evenements = evenements;
    }
}
