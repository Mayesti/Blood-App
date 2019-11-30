/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author My Computer
 */
public class Penanganan {
    private String kondisi;
    private String hal;
    
    public Penanganan (String kondisi,String hal){
        this.kondisi=kondisi;
        this.hal=hal;
    }

    /**
     * @return the kondisi
     */
    public String getKondisi() {
        return kondisi;
    }

    /**
     * @param kondisi the kondisi to set
     */
    public void setKondisi(String kondisi) {
        this.kondisi = kondisi;
    }

    /**
     * @return the hal
     */
    public String getHal() {
        return hal;
    }

    /**
     * @param hal the hal to set
     */
    public void setHal(String hal) {
        this.hal = hal;
    }
    
}
