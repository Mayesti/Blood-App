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
    private Spinner<Integer> spntinggi;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        SpinnerValueFactory<Integer> valueFactorySistol=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryDiastol=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryPulse=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryGula=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryBerat=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryTinggi=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        spnsistol.setValueFactory(valueFactorySistol);
        spndiastol.setValueFactory(valueFactoryDiastol);
        spnpulse.setValueFactory(valueFactoryPulse);
        spngula.setValueFactory(valueFactoryGula);
        spnberat.setValueFactory(valueFactoryBerat);
        spntinggi.setValueFactory(valueFactoryTinggi);
    }
    
    @FXML
    void btnTambahData(ActionEvent event) throws IOException {
        String username=UserLogin.username;
        String sistol=spnsistol.getEditor().getText();
        String diastol=spndiastol.getEditor().getText();
        String pulse=spnpulse.getEditor().getText();
        String gula=spngula.getEditor().getText();
        String berat=spnberat.getEditor().getText();
        String tinggi=spntinggi.getEditor().getText();
        Date currentDate=new Date();
        SimpleDateFormat formatter=new SimpleDateFormat("yyyy-MM-dd");
        String tanggalSkrg=formatter.format(currentDate);
        
        int sistolint = Integer.parseInt(sistol);
        int diastolint = Integer.parseInt(diastol);
        int pulseint = Integer.parseInt(pulse);
        int gulaint = Integer.parseInt(gula);
        int beratint = Integer.parseInt(berat);
        int tinggiint = Integer.parseInt(tinggi);
        
        if((sistolint <30) || (sistolint >1000) || (diastolint <30) || (diastolint >1000) || (pulseint <30) || (pulseint >1000) || (gulaint <30) || (gulaint >1000) || (beratint <20) || (beratint >1000) || (tinggiint <45) || (tinggiint >1000)){
            showMessageDialog(null, "Angka tidak valid!");
        }else{
            
        String sql="INSERT INTO data(username,sistol,diastol,pulse,gula_darah,berat,tinggi,waktu_tambah) VALUES('"+username+"',"
                + ""+sistol+","+diastol+","+pulse+","+gula+","+berat+","+tinggi+",'"+tanggalSkrg+"')";
        //showMessageDialog(null,sql);
        try{
            Connection con=Db.connectDB();
            Statement stmt=con.createStatement();
            stmt.executeUpdate(sql);
        }
        catch(SQLException e){
            showMessageDialog(null,e.getMessage());
        }
        showMessageDialog(null,"Data berhasil dimasukkan!");
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/menu.fxml"));
        Scene scene = new Scene(root);
        scene.getStylesheets().add("/style/Style.css");
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();

        System.out.println("Berhasil");
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
