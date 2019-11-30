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
    private String gejala;
    
    public Penyakit(String namaPenyakit, String gejala){
        this.namaPenyakit=namaPenyakit;
        this.gejala=gejala;
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
     * @return the gejala
     */
    public String getGejala() {
        return gejala;
    }

    /**
     * @param gejala the gejala to set
     */
    public void setGejala(String gejala) {
        this.gejala = gejala;
    }

   
}
