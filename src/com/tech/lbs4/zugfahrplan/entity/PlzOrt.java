package com.tech.lbs4.zugfahrplan.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "plz_ort")
public class PlzOrt {
    @Id
    @Column(name = "plz_ort_id", nullable = false)
    private Integer id;

    @Column(name = "plz", nullable = false, length = 11)
    private String plz;

    @Column(name = "ort", nullable = false, length = 11)
    private String ort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPlz() {
        return plz;
    }

    public void setPlz(String plz) {
        this.plz = plz;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

}