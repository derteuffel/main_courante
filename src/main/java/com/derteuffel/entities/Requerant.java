package com.derteuffel.entities;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 * Created by derteuffel on 27/08/2018.
 */
@Entity
public class Requerant extends User {
    @Column
    private String quartier;
}
