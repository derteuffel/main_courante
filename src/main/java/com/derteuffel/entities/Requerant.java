package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by derteuffel on 27/08/2018.
 */
@Entity
public class Requerant extends User {
    @Column
    private String quartier;

    public Requerant() {
    }

    public Requerant(String nom, String type, String prenom, String empreinte_digit, String NCNI, String profession, String lieu_de_naissance, Date date_naissance, String quartier) {
        super(nom, type, prenom, empreinte_digit, NCNI, profession, lieu_de_naissance, date_naissance);
        this.quartier = quartier;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
}
