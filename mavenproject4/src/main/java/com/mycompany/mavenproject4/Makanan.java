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
    public Makanan(String jenisMakanan,String porsi,String namaMakanan,String keterangan){
        this.jenisMakanan=jenisMakanan;
        this.porsi=porsi;
        this.namaMakanan=namaMakanan;
        this.keterangan=keterangan;
    }

    /**
     * @return the jenisMakanan
     */
    public String getJenisMakanan() {
        return jenisMakanan;
    }

    /**
     * @param jenisMakanan the jenisMakanan to set
     */
    public void setJenisMakanan(String jenisMakanan) {
        this.jenisMakanan = jenisMakanan;
    }

    /**
     * @return the porsi
     */
    public String getPorsi() {
        return porsi;
    }

    /**
     * @param porsi the porsi to set
     */
    public void setPorsi(String porsi) {
        this.porsi = porsi;
    }

    /**
     * @return the namaMakanan
     */
    public String getNamaMakanan() {
        return namaMakanan;
    }

    /**
     * @param namaMakanan the namaMakanan to set
     */
    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    /**
     * @return the keterangan
     */
    public String getKeterangan() {
        return keterangan;
    }

    /**
     * @param keterangan the keterangan to set
     */
    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }
    
}
