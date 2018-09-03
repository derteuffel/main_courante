package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Engin extends Materiel {



    @Column
   private String numero_chassis;

    @Column
    private String genre;

    @Column
    private String imatriculation;


    public Engin() {
    }

    public Engin(String marque, String type, String couleur, String status, String numero_chassis, String genre, String imatriculation) {
        super(marque, type, couleur, status);
        this.numero_chassis = numero_chassis;
        this.genre = genre;
        this.imatriculation = imatriculation;
    }


    public String getNumero_chassis() {
        return numero_chassis;
    }

    public void setNumero_chassis(String numero_chassis) {
        this.numero_chassis = numero_chassis;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getImatriculation() {
        return imatriculation;
    }

    public void setImatriculation(String imatriculation) {
        this.imatriculation = imatriculation;
    }
}
