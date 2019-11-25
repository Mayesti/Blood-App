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
public class Olahraga {
    private String namaOlahraga;
    public Olahraga(String namaOlahraga){
        this.namaOlahraga=namaOlahraga;
    }
    
    public String getNamaOlahraga(){
        return namaOlahraga;
    }
    public void setNamaOlahraga(String namaOlahraga){
        this.namaOlahraga = namaOlahraga;
    }
}