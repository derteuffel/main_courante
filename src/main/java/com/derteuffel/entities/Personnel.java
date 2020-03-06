package com.derteuffel.entities;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
@PrimaryKeyJoinColumn(name = "id")
public class Personnel extends User {

    @Column
    private String matricule, grade, fonction,status;

    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Temporal(TemporalType.DATE)
    private Date date_prise_service;

    public Personnel() {
    }

    public Personnel(String nom, String type, String telephone, String avatar, String prenom, String empreinte_digit, String NCNI, String profession, String lieu_de_naissance,
                     Date date_naissance, String matricule, String grade, String fonction, String status, Date date_prise_service) {
        super(nom, type, telephone, avatar, prenom, empreinte_digit, NCNI, profession, lieu_de_naissance, date_naissance);
        this.matricule = matricule;
        this.grade = grade;
        this.fonction = fonction;
        this.status = status;
        this.date_prise_service = date_prise_service;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public String getFonction() {
        return fonction;
    }

    public void setFonction(String fonction) {
        this.fonction = fonction;
    }

    public Date getDate_prise_service() {
        return date_prise_service;
    }

    public void setDate_prise_service(Date date_prise_service) {
        this.date_prise_service = date_prise_service;
    }
}
