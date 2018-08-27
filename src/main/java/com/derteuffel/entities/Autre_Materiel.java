package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Autre_Materiel extends Materiel {

    @Column
    private String numero_serie, type;

    public Autre_Materiel() {
    }

    public Autre_Materiel(String marque, String nature, String couleur, String numero_serie, String type) {
        super(marque, nature, couleur);
        this.numero_serie = numero_serie;
        this.type = type;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
