package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Evenement implements Serializable {

    @Id
    @GeneratedValue
    @Column( updatable = false, nullable = false)
    private Long id;

    @Column
    private String N_ordre, nature, saisine, lieu, commentaire, type;

    @Column
    @Temporal(TemporalType.DATE)
    private Date heure_evenement;

    //add reference for equipe object

    @ManyToMany(mappedBy = "evenements")
    private Set<User> users;


    @OneToOne
    private Observation observation;
    @ManyToOne
    private Equipe equipe;

    public Evenement() {
    }

    public Evenement(String n_ordre, String nature,String type, String saisine, String lieu, String commentaire, Date heure_evenement) {
        N_ordre = n_ordre;
        this.type=type;
        this.nature = nature;
        this.saisine = saisine;
        this.lieu = lieu;
        this.commentaire = commentaire;
        this.heure_evenement = heure_evenement;
    }

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getN_ordre() {
        return N_ordre;
    }

    public void setN_ordre(String n_ordre) {
        N_ordre = n_ordre;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }

    public String getSaisine() {
        return saisine;
    }

    public void setSaisine(String saisine) {
        this.saisine = saisine;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Date getHeure_evenement() {
        return heure_evenement;
    }

    public void setHeure_evenement(Date heure_evenement) {
        this.heure_evenement = heure_evenement;
    }

    public Equipe getEquipe() {
        return equipe;
    }

    public void setEquipe(Equipe equipe) {
        this.equipe = equipe;

    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public Observation getObservation() {
        return observation;
    }

    public void setObservation(Observation observation) {
        this.observation = observation;
    }
}
