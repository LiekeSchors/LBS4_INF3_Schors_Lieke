package com.tech.lbs4.zugfahrplan.entity;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Table(name = "fahrplan")
public class Fahrplan {
    @Id
    @Column(name = "fahrplan_id", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "zug_id", nullable = false)
    private Zug zug;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bahnsteig_id", nullable = false)
    private Bahnsteig bahnsteig;

    @Lob
    @Column(name = "typ", nullable = false)
    private String typ;

    @Lob
    @Column(name = "wochentag", nullable = false)
    private String wochentag;

    @Column(name = "uhrzeit", nullable = false)
    private LocalTime uhrzeit;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Zug getZug() {
        return zug;
    }

    public void setZug(Zug zug) {
        this.zug = zug;
    }

    public Bahnsteig getBahnsteig() {
        return bahnsteig;
    }

    public void setBahnsteig(Bahnsteig bahnsteig) {
        this.bahnsteig = bahnsteig;
    }

    public String getTyp() {
        return typ;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public String getWochentag() {
        return wochentag;
    }

    public void setWochentag(String wochentag) {
        this.wochentag = wochentag;
    }

    public LocalTime getUhrzeit() {
        return uhrzeit;
    }

    public void setUhrzeit(LocalTime uhrzeit) {
        this.uhrzeit = uhrzeit;
    }

}