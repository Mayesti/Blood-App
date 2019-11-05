/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class MenuController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private Label lbwelcome;
    
    
    @FXML
    private void btntambahdata(ActionEvent event){
        //showMessageDialog(null,"tes");
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/tambahData.fxml"));
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
    private void btnriwayat(ActionEvent event){
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

    @FXML
    private void btnanalisis(ActionEvent event){
       
    }
    
    @FXML
    private void btngrafik(ActionEvent event){
       
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
    private void btnLogout(ActionEvent event){
       
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String username = UserLogin.username;
        lbwelcome.setText("Selamat Datang, " + username);
    
    }    
    
}
