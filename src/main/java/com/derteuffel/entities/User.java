package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements Serializable {

    @Id
    @GeneratedValue
    @Column( updatable = false, nullable = false)
    private Long id;

    @Column
    private String nom, prenom, telephone, NCNI,profession, lieu_de_naissance, empreinte_digit, type;

    @Column
    private Date date_naissance;

    //reference for Evenement List element

    @ManyToMany
    private Set<Evenement> evenements;

    @OneToMany(mappedBy = "user")
    private List<Materiel> materiels;

    @ManyToOne
    private Equipe equipe;

    public User() {
    }

    public User(String nom,String type, String prenom, String empreinte_digit, String NCNI, String profession, String lieu_de_naissance, Date date_naissance) {
        this.nom = nom;
        this.type=type;
        this.prenom = prenom;
        this.telephone = telephone;
        this.NCNI = NCNI;
        this.profession = profession;
        this.lieu_de_naissance = lieu_de_naissance;
        this.date_naissance = date_naissance;
        this.empreinte_digit=empreinte_digit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmpreinte_digit() {
        return empreinte_digit;
    }

    public void setEmpreinte_digit(String empreinte_digit) {
        this.empreinte_digit = empreinte_digit;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;
    }

       public List<Materiel> getMateriels() {
        return materiels;
    }

    public void setMateriels(List<Materiel> materiels) {
        this.materiels = materiels;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNCNI() {
        return NCNI;
    }

    public void setNCNI(String NCNI) {
        this.NCNI = NCNI;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getLieu_de_naissance() {
        return lieu_de_naissance;
    }

    public void setLieu_de_naissance(String lieu_de_naissance) {
        this.lieu_de_naissance = lieu_de_naissance;
    }

    public Date getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(Date date_naissance) {
        this.date_naissance = date_naissance;
    }

    public Set<Evenement> getEvenements() {
        return evenements;
    }

    public void setEvenements(Set<Evenement> evenements) {
        this.evenements = evenements;
    }
}
