package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author Mayesti
 */
public class UbahPasswordController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private PasswordField pfLama;
    
    @FXML
    private PasswordField pfBaru;
    
    @FXML
    private PasswordField pfKonfirm;
    
    @FXML
    private Label labelAlert;
        
    @FXML
    private void btnSimpan(ActionEvent event)throws SQLException, IOException{
        String username = UserLogin.username;
        String password = UserLogin.password;
        String lama = pfLama.getText();
        String baru = pfBaru.getText();
        String konfirm = pfKonfirm.getText();
        String sql = "update user set password='"+baru+"' where username='"+username+"'"; 
        
        if(!lama.isEmpty() && !baru.isEmpty() && !konfirm.isEmpty()){
            
//            if(lama != password){
//                labelAlert.setText("Password lama salah!");
//            }else if(baru != konfirm){
//                labelAlert.setText("Password baru tidak sama dengan password konfirmasi!");
//            }else if(lama == baru && baru == konfirm){
            if(baru.equals(konfirm)){
                try{
                    Connection con = Db.connectDB();
                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(sql);
                
                    labelAlert.setText(" ");
                }
                catch(SQLException e){
                    showMessageDialog(null,e.getMessage());
                }
            
                showMessageDialog(null,"Password berhasil disimpan!");
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/style/Style.css");
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
//            }
            }else{
                labelAlert.setText("Password baru tidak sesuai dengan password konfirmasi!");
            }
        }else{
            labelAlert.setText("Semua field harus diisi!");
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
    }    
    
}
