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
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mayesti
 */
public class SignUpController implements Initializable {
    
    @FXML
    private Label falsePass;
    
    @FXML
    private TextField tfUsername;
    
    @FXML
    private TextField tfEmail;
    
    @FXML
    private PasswordField pfPassword;
    
    @FXML
    private PasswordField pfKonfirm;
    
    @FXML
    private DatePicker dpTgl;
    
    @FXML
    private RadioButton rbPria;
    
    @FXML
    private RadioButton rbWanita;
    
    private Connection con = null;
    
    @FXML
    private void btnRegister(ActionEvent event) throws SQLException, IOException{
//        System.out.println("clicked btn login");
        String username = tfUsername.getText();
        String email = tfEmail.getText();
        String tgl = dpTgl.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String gender;
        if(rbPria.isSelected()){
            gender = "L";
        }else{
            gender = "P";
        }
        String password = pfPassword.getText();
        String konfirm = pfKonfirm.getText();
                 
        
            String url = "jdbc:sqlite:logiin.db";
            con = DriverManager.getConnection(url);
            Statement p = con.createStatement();
//            System.out.println(usern);
//            System.out.println(pass);
            String insert = "insert into user (username, password, email, tgl_lahir, jenis_kelamin) values ('"+username+"','"+password+"','"+email+"','"+tgl+"','"+gender+"')";
            if(password.equals(konfirm)){
                int q = p.executeUpdate(insert);
                if(q == 1){
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Homee.fxml"));
                    Scene scene = new Scene(root);
                    scene.getStylesheets().add("/style/Style.css");
                    Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                    window.setScene(scene);
                    window.show();
                    
                    System.out.println("Berhasil");
                    falsePass.setText(" ");
                    
                }else{
                    System.out.println("Gagal");
                }
            }
            else {
                falsePass.setText("Password dan konfirmasi password harus sama!");
            }
            
                
            
            
                
        } 
    
     
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
