package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author My Computer
 */
public class EditDataController implements Initializable {
        @FXML
    private Label lSistol;

    @FXML
    private Label lPulse;

    @FXML
    private Button btnSimpan;

    @FXML
    private Label lGulDar;

    @FXML
    private Label lBerat;

    @FXML
    private Label lDiastol;

    @FXML
    private Label lTinggi;

    @FXML
    void btnSimpanData(ActionEvent event) {

    }

    @FXML
    void btnBack(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
