package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Suspect extends User {
@Column
    private String arrondissement, coutume, departement_d_origine, sit_matrimoniale, nom_pere, nom_mere, dist_honorifique, quartier, photo, nationalite;

    public Suspect() {
    }

    public Suspect(String nom, String prenom, String telephone, String NCNI, String profession, String lieu_de_naissance,
                   Date date_naissance, String arrondissement, String coutume, String departement_d_origine, String sit_matrimoniale,
                   String nom_pere, String nom_mere, String dist_honorifique, String quartier, String photo, String nationalite) {
        super(nom, prenom, telephone, NCNI, profession, lieu_de_naissance, date_naissance);
        this.arrondissement = arrondissement;
        this.coutume = coutume;
        this.departement_d_origine = departement_d_origine;
        this.sit_matrimoniale = sit_matrimoniale;
        this.nom_pere = nom_pere;
        this.nom_mere = nom_mere;
        this.dist_honorifique = dist_honorifique;
        this.quartier = quartier;
        this.photo = photo;
        this.nationalite = nationalite;
    }


    public String getArrondissement() {
        return arrondissement;
    }

    public void setArrondissement(String arrondissement) {
        this.arrondissement = arrondissement;
    }

    public String getCoutume() {
        return coutume;
    }

    public void setCoutume(String coutume) {
        this.coutume = coutume;
    }

    public String getDepartement_d_origine() {
        return departement_d_origine;
    }

    public void setDepartement_d_origine(String departement_d_origine) {
        this.departement_d_origine = departement_d_origine;
    }

    public String getSit_matrimoniale() {
        return sit_matrimoniale;
    }

    public void setSit_matrimoniale(String sit_matrimoniale) {
        this.sit_matrimoniale = sit_matrimoniale;
    }

    public String getNom_pere() {
        return nom_pere;
    }

    public void setNom_pere(String nom_pere) {
        this.nom_pere = nom_pere;
    }

    public String getNom_mere() {
        return nom_mere;
    }

    public void setNom_mere(String nom_mere) {
        this.nom_mere = nom_mere;
    }

    public String getDist_honorifique() {
        return dist_honorifique;
    }

    public void setDist_honorifique(String dist_honorifique) {
        this.dist_honorifique = dist_honorifique;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }
}
