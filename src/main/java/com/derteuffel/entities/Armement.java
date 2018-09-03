package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Armement extends Materiel {

    @Column
    private String numero, genre;

    @Column
    private int calibre;


    public Armement() {
    }

    public Armement(String marque, String type, String couleur,String status, String numero, String genre, int calibre) {
        super(marque, type, couleur, status);
        this.numero = numero;
        this.genre = genre;
        this.calibre = calibre;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getCalibre() {
        return calibre;
    }

    public void setCalibre(int calibre) {
        this.calibre = calibre;
    }
}
