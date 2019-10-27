package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.awt.event.MouseEvent;
import java.net.URL;
import java.sql.Connection;
import java.util.ResourceBundle;
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
    private RadioButton rbGender;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private DatePicker dpTanggal;
    
    /**
     * Initializes the controller class.
     */
    
    @FXML
    void signup(MouseEvent event){
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
