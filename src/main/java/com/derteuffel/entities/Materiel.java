package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Materiel implements Serializable {

    @Id
    @GeneratedValue
    @Column( updatable = false, nullable = false)
    private Long id;

    @Column
    private String marque, nature,couleur;

    public Materiel() {
    }

    public Materiel(String marque, String nature,String couleur) {
        this.marque = marque;
        this.nature = nature;
        this.couleur=couleur;
    }


    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public String getNature() {
        return nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
