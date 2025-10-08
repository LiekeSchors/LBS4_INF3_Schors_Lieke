package com.tech.lbs4.zugfahrplan.entity;

import javax.persistence.*;

@Entity
@Table(name = "bahnhof")
public class Bahnhof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bahnhof_id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 200)
    private String name;

    @Column(name = "stadt_id", nullable = false)
    private int stadt;

    @Column(name = "kopfbahnhof", nullable = false)
    private Boolean kopfbahnhof = false;

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

    public int getStadt() {
        return stadt;
    }

    public void setStadt(int stadt) {
        this.stadt = stadt;
    }

    public Boolean getKopfbahnhof() {
        return kopfbahnhof;
    }

    public void setKopfbahnhof(Boolean kopfbahnhof) {
        this.kopfbahnhof = kopfbahnhof;
    }
}