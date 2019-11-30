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
public class ResikoPenyakitController implements Initializable {

    /**
     * Initializes the controller class.
     */
    private String dtd,dgd;
    
    private ObservableList<Penyakit> listPenyakit = FXCollections.observableArrayList();
    
    
    @FXML
    private Label lblDiagnosaTekananDarah,lblDiagnosaGulaDarah;
    
    @FXML
    private TableView tvDaftarPenyakit;
    
    @FXML
    private TableColumn<Penyakit,String> colNamaPenyakit;
    
//    @FXML
//    private TableColumn<Penyakit,String> colKeterangan;
    
    public void initDiagnosaData(String dtd,String dgd){
        this.dtd=dtd;
        this.dgd=dgd;
        lblDiagnosaTekananDarah.setText(dtd);
        lblDiagnosaGulaDarah.setText(dgd);
        colNamaPenyakit.setCellValueFactory(new PropertyValueFactory<Penyakit,String>("namaPenyakit"));
//        colKeterangan.setCellValueFactory(new PropertyValueFactory<Penyakit,String>("keterangan"));
        listPenyakit.clear();
        if(this.dtd.equals("normal") && this.dtd.equals("normal")){
            tvDaftarPenyakit.setVisible(false);
            colNamaPenyakit.setVisible(false);
        }else{
        try{
            String sql="SELECT distinct nama_penyakit, gejala FROM resiko_penyakit WHERE diagnosa='"+dtd+"' OR diagnosa='"+dgd+"'";
            Connection con=Db.connectDB();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String namaPenyakit = rs.getString("nama_penyakit");
                String gejala = rs.getString("gejala");
                
                listPenyakit.add(new Penyakit(namaPenyakit, gejala));
//                  listPenyakit.add(new Penyakit(rs.getString("nama_penyakit")));
            }
            tvDaftarPenyakit.setItems(listPenyakit);
        }
        catch(SQLException e){
            
        }
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
    Parent root = FXMLLoader.load(getClass().getResource("/fxml/resikoPenyakit.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style/Style.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();  
    }

    @FXML
    private void olahraga(ActionEvent event) throws IOException {
    FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/olahraga.fxml"));
        Scene scene = new Scene((Parent)root.load());
        OlahragaController olahragaController=root.getController();
        olahragaController.initDiagnosaData(dtd, dgd);
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
