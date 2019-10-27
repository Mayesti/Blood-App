package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mayesti
 */
public class SignUpController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TextField guladarah;

    @FXML
    private Label usernamedisplay;

    @FXML
    private TextField diastol;

    @FXML
    private TextField berat;
    
    @FXML
    private TextField pulse;

    @FXML
    private Label label;

    @FXML
    private TextField sistol;

    private Connection conn = null;
    
     @FXML
    private void btntambahdata(ActionEvent event) throws SQLException, IOException{
       String sistoldata = sistol.getText();
       String diastoldata = diastol.getText();
       String pulsedata = pulse.getText();
       String guladarahdata = guladarah.getText();
       String beratdata = berat.getText();
       
       String url = "jdbc:sqlite:logiin.db";
            conn = DriverManager.getConnection(url);
            Statement p = conn.createStatement();
            System.out.println(sistoldata);
            System.out.println(diastoldata);
            System.out.println(pulsedata);
            System.out.println(guladarahdata);
            System.out.println(beratdata);
            String query = "insert into tambahData values ('"+sistoldata+"','"+diastoldata+"','"+pulsedata+"',"
            + "'"+guladarahdata+"' , '"+beratdata+"')";
            
            ResultSet rs = p.executeQuery(query);
            if(rs.next()){
                System.out.println("Data berhasil dimasukkan!");
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/Home.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } else {
                if(pulsedata.equals("")){
//                        || (guladarahdata.equals("")) ||
//                        (sistoldata.equals(" ")) || (diastoldata.equals(" ")) || (beratdata.equals("")){
////                    pesan.setText("");
                }
                else{
//                    pesan.setText("");
            }
                
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    }

    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        // TODO
//    }    
//    
//}
