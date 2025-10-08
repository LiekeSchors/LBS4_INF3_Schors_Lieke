package com.tech.lbs4.zugfahrplan.entity;

import javax.persistence.*;

@Entity
@Table(name = "bahnsteig")
public class Bahnsteig {
    @Id
    @Column(name = "bahnsteig_id", nullable = false)
    private Integer id;

    @Column(name = "bahnhof_id", nullable = false)
    private int bahnhofId;

    @Column(name = "bahnsteig_nr", nullable = false)
    private Integer bahnsteigNr;

    @Column(name = "barrierefrei", nullable = false)
    private Boolean barrierefrei = false;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getBahnhofId() {
        return bahnhofId;
    }

    public void setBahnhofId(int bahnhofId) {
        this.bahnhofId = bahnhofId;
    }

    public Integer getBahnsteigNr() {
        return bahnsteigNr;
    }

    public void setBahnsteigNr(Integer bahnsteigNr) {
        this.bahnsteigNr = bahnsteigNr;
    }

    public Boolean getBarrierefrei() {
        return barrierefrei;
    }

    public void setBarrierefrei(Boolean barrierefrei) {
        this.barrierefrei = barrierefrei;
    }

}