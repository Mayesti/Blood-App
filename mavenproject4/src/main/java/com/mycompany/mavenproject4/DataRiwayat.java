/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author My Computer
 */
public class DataRiwayat {
    private String tanggal;
    private Integer sistolik;
    private Integer diastolik;
    private Integer pulse;
    private Integer gulaDarah;
    private Integer beratBadan;
    private Integer tinggiBadan;
    public DataRiwayat(String tanggal,int sistolik,int diastolik,int pulse,int gulaDarah,int beratBadan,int tinggiBadan){
        this.tanggal=tanggal;
        this.sistolik=sistolik;
        this.diastolik=diastolik;
        this.pulse=pulse;
        this.gulaDarah=gulaDarah;
        this.beratBadan=beratBadan;
        this.tinggiBadan=tinggiBadan;
    }

    /**
     * @return the tanggal
     */
    public String getTanggal() {
        return tanggal;
    }

    /**
     * @param tanggal the tanggal to set
     */
    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    /**
     * @return the sistolik
     */
    public Integer getSistolik() {
        return sistolik;
    }

    /**
     * @param sistolik the sistolik to set
     */
    public void setSistolik(Integer sistolik) {
        this.sistolik = sistolik;
    }

    /**
     * @return the diastolik
     */
    public Integer getDiastolik() {
        return diastolik;
    }

    /**
     * @param diastolik the diastolik to set
     */
    public void setDiastolik(Integer diastolik) {
        this.diastolik = diastolik;
    }

    /**
     * @return the pulse
     */
    public Integer getPulse() {
        return pulse;
    }

    /**
     * @param pulse the pulse to set
     */
    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    /**
     * @return the gulaDarah
     */
    public Integer getGulaDarah() {
        return gulaDarah;
    }

    /**
     * @param gulaDarah the gulaDarah to set
     */
    public void setGulaDarah(Integer gulaDarah) {
        this.gulaDarah = gulaDarah;
    }

    /**
     * @return the beratBadan
     */
    public Integer getBeratBadan() {
        return beratBadan;
    }

    /**
     * @param beratBadan the beratBadan to set
     */
    public void setBeratBadan(Integer beratBadan) {
        this.beratBadan = beratBadan;
    }

    /**
     * @return the tinggiBadan
     */
    public Integer getTinggiBadan() {
        return tinggiBadan;
    }

    /**
     * @param tinggiBadan the tinggiBadan to set
     */
    public void setTinggiBadan(Integer tinggiBadan) {
        this.tinggiBadan = tinggiBadan;
    }
}
