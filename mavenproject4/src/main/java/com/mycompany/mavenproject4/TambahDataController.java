/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class TambahDataController implements Initializable {

    /**
     * Initializes the controller class.
     */

    @FXML
    private Spinner<Integer> spnpulse;

    @FXML
    private Spinner<Integer> spngula;

    @FXML
    private Spinner<Integer> spnberat;

    @FXML
    private Spinner<Integer> spnsistol;

    @FXML
    private Spinner<Integer> spndiastol;
    
    @FXML
    private Button btnTambahData;
    
    @FXML
    private DatePicker dpTgl;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactorySistol=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryDiastol=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryPulse=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryGula=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryBerat=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        spnsistol.setValueFactory(valueFactorySistol);
        spndiastol.setValueFactory(valueFactoryDiastol);
        spnpulse.setValueFactory(valueFactoryPulse);
        spngula.setValueFactory(valueFactoryGula);
        spnberat.setValueFactory(valueFactoryBerat);
        LocalDate tglSkrg=LocalDate.now();
        dpTgl.setValue(tglSkrg);
    }
    
    @FXML
    void btnTambahData(ActionEvent event) throws IOException {
        String username=UserLogin.username;
        String sistol=spnsistol.getEditor().getText();
        String diastol=spndiastol.getEditor().getText();
        String pulse=spnpulse.getEditor().getText();
        String gula=spngula.getEditor().getText();
        String berat=spnberat.getEditor().getText();
        String tanggal=dpTgl.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        
        int sistolint = Integer.parseInt(sistol);
        int diastolint = Integer.parseInt(diastol);
        int pulseint = Integer.parseInt(pulse);
        int gulaint = Integer.parseInt(gula);
        int beratint = Integer.parseInt(berat);
        
        if((sistolint <30) || (sistolint >1000) || (diastolint <30) || (diastolint >1000) || (pulseint <30) || (pulseint >1000) || (gulaint <30) || (gulaint >1000) || (beratint <20) || (beratint >1000)){
            showMessageDialog(null, "Angka tidak valid!");
        }else{
            
            String sql="INSERT INTO data(username,sistol,diastol,pulse,gula_darah,berat,waktu_tambah) VALUES('"+username+"',"
                    + ""+sistol+","+diastol+","+pulse+","+gula+","+berat+",'"+tanggal+"')";
            //showMessageDialog(null,sql);
            try{
                Connection con=Db.connectDB();
                Statement stmt=con.createStatement();
                stmt.executeUpdate(sql);
                showMessageDialog(null,"Data berhasil dimasukkan!");
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/style/Style.css");
                Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();

            System.out.println("Berhasil");
            }
            catch(SQLException e){
                showMessageDialog(null,e.getMessage());
            }
        
        }
        
    }
    @FXML
    private void btnBack(ActionEvent event) throws IOException{
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
}
