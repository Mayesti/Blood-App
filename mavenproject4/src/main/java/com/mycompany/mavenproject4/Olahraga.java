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
    private String durasi;
    private String keterangan;
    private String fungsi;
    
    public Olahraga(String namaOlahraga, String durasi, String keterangan, String fungsi){
        this.namaOlahraga=namaOlahraga;
        this.durasi=durasi;
        this.keterangan=keterangan;
        this.fungsi=fungsi;
    }
    
    public String getNamaOlahraga(){
        return namaOlahraga;
    }
    public void setNamaOlahraga(String namaOlahraga){
        this.namaOlahraga = namaOlahraga;
    }

    /**
     * @return the durasi
     */
    public String getDurasi() {
        return durasi;
    }

    /**
     * @param durasi the durasi to set
     */
    public void setDurasi(String durasi) {
        this.durasi = durasi;
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

    /**
     * @return the fungsi
     */
    public String getFungsi() {
        return fungsi;
    }

    /**
     * @param fungsi the fungsi to set
     */
    public void setFungsi(String fungsi) {
        this.fungsi = fungsi;
    }
}