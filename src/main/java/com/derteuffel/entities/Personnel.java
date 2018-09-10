package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Date;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Personnel extends User {

    @Column
    private String matricule, grade, fonction,status;

    @Column
    private Date date_prise_service;

    public Personnel() {
    }

    public Personnel(String nom, String prenom, String telephone, String NCNI, String profession,String type,
                     String lieu_de_naissance, Date date_naissance, String matricule, String grade,
                     String fonction, Date date_prise_service,String status) {
        super(nom, prenom, telephone, NCNI, profession, lieu_de_naissance,type, date_naissance);
        this.matricule = matricule;
        this.grade = grade;
        this.fonction = fonction;
        this.date_prise_service = date_prise_service;
        this.status=status;
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
