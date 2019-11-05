/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import static com.mycompany.mavenproject4.UserLogin.username;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class EditProfilController implements Initializable {

    /**
     * Initializes the controller class.
     */
     @FXML
    private TextField tfemail;

    @FXML
    private TextField tfnama;

    @FXML
    private TextField tfusername;

    @FXML
    private void btnsimpan(ActionEvent event) {
        String usernamebaru = tfusername.getText();
        String namabaru = tfnama.getText();
        String emailbaru = tfemail.getText();
        if(!usernamebaru.isEmpty() && !namabaru.isEmpty() && !emailbaru.isEmpty()){
             String sql = "update user set nama='"+namabaru+"', username='"+usernamebaru+"', email ='"+emailbaru+"' where username='"+username+"'"; 
            try{
                Connection con=Db.connectDB();
                Statement stmt=con.createStatement();
                stmt.executeUpdate(sql);
            }
            catch(SQLException e){
                showMessageDialog(null,e.getMessage());
            }
            UserLogin.nama = namabaru;
            UserLogin.username = usernamebaru;
            UserLogin.email = emailbaru;
            
            try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
        }
        else{
            showMessageDialog(null, "Field harus terisi semua!");
        }
         
       
    }

    @FXML
    private void btnBatal(ActionEvent event) throws IOException{
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        String username = UserLogin.username;
        String nama = UserLogin.nama;
        String email = UserLogin.email;
        
        tfnama.setText(nama);
        tfusername.setText(username);
        tfemail.setText(email);
        
    }    
    
}
