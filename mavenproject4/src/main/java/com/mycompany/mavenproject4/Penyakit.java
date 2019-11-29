/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

/**
 *
 * @author ASUS
 */
public class Penyakit {
    private String namaPenyakit;
//    private String keterangan;
    
    public Penyakit(String namaPenyakit){
        this.namaPenyakit=namaPenyakit;
    }

    /**
     * @return the namaPenyakit
     */
    public String getNamaPenyakit() {
        return namaPenyakit;
    }

    /**
     * @param namaPenyakit the namaPenyakit to set
     */
    public void setNamaPenyakit(String namaPenyakit) {
        this.namaPenyakit = namaPenyakit;
    }

    /**
     * @return the keterangan
     */
//    public String getKeterangan() {
//        return keterangan;
//    }
//
//    /**
//     * @param keterangan the keterangan to set
//     */
//    public void setKeterangan(String keterangan) {
//        this.keterangan = keterangan;
//    }

    
    
}
