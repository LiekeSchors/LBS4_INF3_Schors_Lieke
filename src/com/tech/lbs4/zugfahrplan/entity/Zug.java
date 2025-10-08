package com.tech.lbs4.zugfahrplan.entity;

import javax.persistence.*;

@Entity
@Table(name = "zug")
public class Zug {
    @Id
    @Column(name = "zug_id", nullable = false)
    private Integer id;

    @Column(name = "name", length = 11)
    private String name;

    @Lob
    @Column(name = "zug_typ", nullable = false)
    private String zugTyp;

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

    public String getZugTyp() {
        return zugTyp;
    }

    public void setZugTyp(String zugTyp) {
        this.zugTyp = zugTyp;
    }

}