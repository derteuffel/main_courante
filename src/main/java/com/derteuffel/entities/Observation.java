package com.derteuffel.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by derteuffel on 27/08/2018.
 */

@Entity
public class Observation implements Serializable {


    @Id
    @GeneratedValue
    @Column( updatable = false, nullable = false)
    private Long id;

    @Column
    private String desc_observation;

    @Column
    @Temporal(TemporalType.DATE)
    private Date date_observation;

    public Observation() {
    }

    public Observation(String desc_observation, Date date_observation) {
        this.desc_observation = desc_observation;
        this.date_observation=date_observation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc_observation() {
        return desc_observation;
    }

    public void setDesc_observation(String desc_observation) {
        this.desc_observation = desc_observation;
    }

    public Date getDate_observation() {
        return date_observation;
    }

    public void setDate_observation(Date date_observation) {
        this.date_observation = date_observation;
    }
}
