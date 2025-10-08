package com.tech.lbs4.zugfahrplan.entity;

import javax.persistence.*;

@Entity
@Table(name = "stadt")
public class Stadt {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stadt_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "plz_ort_id", nullable = false)
    private int plzOrtId;

    @Column(name = "einwohner_anzahl", nullable = false)
    private Integer einwohnerAnzahl;

    @Column(name = "bundesland", nullable = false)
    private String bundesland;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlzOrtId() {
        return plzOrtId;
    }

    public void setPlzOrtId(int plzOrtId) {
        this.plzOrtId = plzOrtId;
    }

    public Integer getEinwohnerAnzahl() {
        return einwohnerAnzahl;
    }

    public void setEinwohnerAnzahl(Integer einwohnerAnzahl) {
        this.einwohnerAnzahl = einwohnerAnzahl;
    }

    public String getBundesland() {
        return bundesland;
    }

    public void setBundesland(String bundesland) {
        this.bundesland = bundesland;
    }
}