package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Mayesti
 */
public class SignUpController implements Initializable {
    @FXML
    private TextField tfUsername;
   
    @FXML 
    private TextField tfEmail;
    
    @FXML
    private RadioButton rbPria;
    
    @FXML
    private RadioButton rbWanita;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private DatePicker dpTanggal;
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    void signup(ActionEvent event) throws SQLException{
        
            String username = tfUsername.getText();
            String email = tfEmail.getText();
            String password = pfPassword.getText();
            String tgl = dpTanggal.getTypeSelector();
            String gender;
            if(rbPria.isSelected()){
                 gender = "L";
            }else{
                 gender = "P";
            }
            
            Connection con = null;
            String url = "jdbc:sqlite:logiin.db";
            con = DriverManager.getConnection(url);
            Statement p = con.createStatement();
            
            String query = "insert into user (username, email, jenis kelamin, tanggal lahir, password) values ('"+username+"','"+email+"','"+gender+"','"+tgl+"','"+password+"')";
            ResultSet q = p.executeQuery(query);     
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
