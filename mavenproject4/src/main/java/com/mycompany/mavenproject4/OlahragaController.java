/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author ASUS
 */

public class OlahragaController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String dtd,dgd;
    
    private ObservableList<Olahraga> listOlahraga = FXCollections.observableArrayList();
    
    @FXML
    private Label lblDiagnosaTekananDarah,lblDiagnosaGulaDarah;
    
    @FXML
    private TableView tvDaftarOlahraga;
    
    @FXML
    private TableColumn<Olahraga,String> colNamaOlahraga;
    
    @FXML
    private TableColumn<Olahraga,String> colDurasi;
     
    @FXML
    private TableColumn<Olahraga,String> colKeterangan;
    
    @FXML
    private TableColumn<Olahraga,String> colFungsi;
    
    public void initDiagnosaData(String dtd,String dgd){
        this.dtd=dtd;
        this.dgd=dgd;
        lblDiagnosaTekananDarah.setText(dtd);
        lblDiagnosaGulaDarah.setText(dgd);
        
        colNamaOlahraga.setCellValueFactory(new PropertyValueFactory<Olahraga,String>("namaOlahraga"));
        colDurasi.setCellValueFactory(new PropertyValueFactory<Olahraga,String>("durasi"));
        colKeterangan.setCellValueFactory(new PropertyValueFactory<Olahraga,String>("keterangan"));
        colFungsi.setCellValueFactory(new PropertyValueFactory<Olahraga,String>("fungsi"));
        
        listOlahraga.clear();
        
        try{
            String sql="SELECT nama_olahraga, durasi, keterangan, fungsi FROM olahraga WHERE diagnosa='"+dtd+"' OR diagnosa='"+dgd+"'";
            Connection con=Db.connectDB();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String namaOlahraga = rs.getString("nama_olahraga");
                String durasi = rs.getString("durasi");
                String keterangan = rs.getString("keterangan");
                String fungsi = rs.getString("fungsi");
                listOlahraga.add(new Olahraga(namaOlahraga, durasi, keterangan, fungsi));
            }
            tvDaftarOlahraga.setItems(listOlahraga);
        }
        catch(SQLException e){
            
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void listMakanan(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/listMakanan.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style/Style.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void resikoPenyakit(ActionEvent event) throws IOException {
        FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/resikoPenyakit.fxml"));
        Scene scene = new Scene((Parent)root.load());
        ResikoPenyakitController resikoPenyakitController=root.getController();
        resikoPenyakitController.initDiagnosaData(dtd, dgd);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();  
    }

    @FXML
    private void olahraga(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/olahraga.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style/Style.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void caraPenanganan(ActionEvent event) throws IOException {
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/caraPenanganan.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style/Style.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    @FXML
    private void btnLogout(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }

   @FXML
    private void btnEditProfil(ActionEvent event){
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/editProfil.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    @FXML
    private void btnUbahPass(ActionEvent event){
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ubahPassword.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    @FXML
    private void riwayat(ActionEvent event){
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/History.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
}
