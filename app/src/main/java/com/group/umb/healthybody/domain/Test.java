package com.group.umb.healthybody.domain;

/**
 * Created by tomashavlas on 31.3.2015.
 */
public class Test {
    private long id;
    private Integer pocetBrusakov;
    private Integer pocetDrepov;
    private Integer pocetKlikov;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Integer getPocetBrusakov() {
        return pocetBrusakov;
    }

    public void setPocetBrusakov(Integer pocetBrusakov) {
        this.pocetBrusakov = pocetBrusakov;
    }

    public Integer getPocetDrepov() {
        return pocetDrepov;
    }

    public void setPocetDrepov(Integer pocetDrepov) {
        this.pocetDrepov = pocetDrepov;
    }

    public Integer getPocetKlikov() {
        return pocetKlikov;
    }

    public void setPocetKlikov(Integer pocetKlikov) {
        this.pocetKlikov = pocetKlikov;
    }

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", pocetBrusakov=" + pocetBrusakov +
                ", pocetDrepov=" + pocetDrepov +
                ", pocetKlikov=" + pocetKlikov +
                '}';
    }
}
