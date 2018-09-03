package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Autre_Materiel extends Materiel {

    @Column
    private String numero_serie, type_autre;

    public Autre_Materiel() {
    }

    public Autre_Materiel(String marque, String type, String couleur,String status, String numero_serie, String type_autre) {
        super(marque, type, couleur,status);
        this.numero_serie = numero_serie;
        this.type_autre = type_autre;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }

    public String getType_autre() {
        return type_autre;
    }

    public void setType_autre(String type_autre) {
        this.type_autre = type_autre;
    }
}
