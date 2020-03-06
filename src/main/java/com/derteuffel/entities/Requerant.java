package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import java.util.Date;

/**
 * Created by derteuffel on 27/08/2018.
 */
@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Requerant extends User {
    @Column
    private String quartier;

    public Requerant() {
    }

    public Requerant(String nom, String type, String telephone, String avatar, String prenom, String empreinte_digit, String NCNI,
                     String profession, String lieu_de_naissance, Date date_naissance, String quartier) {
        super(nom, type, telephone, avatar, prenom, empreinte_digit, NCNI, profession, lieu_de_naissance, date_naissance);
        this.quartier = quartier;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }
}
