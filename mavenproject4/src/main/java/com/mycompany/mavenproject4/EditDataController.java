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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author My Computer
 */
public class EditDataController implements Initializable {
    @FXML
    private Spinner<Integer> spnTinggi;

    @FXML
    private Spinner<Integer> spnPulse;

    @FXML
    private Spinner<Integer> spnGula;

    @FXML
    private Spinner<Integer> spnBerat;

    @FXML
    private Spinner<Integer> spnSistol;

    @FXML
    private Spinner<Integer> spnDiastol;
    ;

    @FXML
    void btnSimpanData(ActionEvent event) {
        
    }

    @FXML
    void btnBack(ActionEvent event) {
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
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
