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
public class Makanan {
    private String jenisMakanan;
    private String porsi;
    private String namaMakanan;
    private String keterangan;
    public Makanan(String jenisMakanan){
        this.jenisMakanan=jenisMakanan;
    }

  
    public String getJenisMakanan() {
        return jenisMakanan;
    }

    
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan= jenisMakanan;
    }
    
    

    
    
}
