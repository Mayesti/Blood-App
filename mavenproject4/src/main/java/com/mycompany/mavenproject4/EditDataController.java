package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author My Computer
 */
public class EditDataController implements Initializable {
//    @FXML
//    private Spinner<Integer> spnTinggi;

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
    
    @FXML
    private DatePicker dpTgl;
    
    private int idData;

    @FXML
    private void btnSimpanOnAction(ActionEvent event) {
        String sistol=spnSistol.getEditor().getText();
        String diastol=spnDiastol.getEditor().getText();
        String pulse=spnPulse.getEditor().getText();
        String gula=spnGula.getEditor().getText();
        String berat=spnBerat.getEditor().getText();
        String tanggal=dpTgl.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
//        String tinggi=spnTinggi.getEditor().getText();
        
        int sistolint = Integer.parseInt(sistol);
        int diastolint = Integer.parseInt(diastol);
        int pulseint = Integer.parseInt(pulse);
        int gulaint = Integer.parseInt(gula);
        int beratint = Integer.parseInt(berat);
//        int tinggiint = Integer.parseInt(tinggi);
        
        if((sistolint <30) || (sistolint >145) || (diastolint <60) || (diastolint >110) || (pulseint <50) || (pulseint >120) || (gulaint <80) || (gulaint >140) || (beratint <20) || (beratint >200)){
            showMessageDialog(null, "Angka tidak valid!");
        }else{
            String sql="UPDATE data SET sistol="+sistol+",diastol="+diastol+",pulse="+pulse+",gula_darah="+gula+",berat="+berat+", waktu_tambah='"+tanggal+"' WHERE id_data="+idData;
            try{
                Connection con=Db.connectDB();
                Statement stmt=con.createStatement();
                stmt.executeUpdate(sql);
                con.close();
                Parent root = FXMLLoader.load(getClass().getResource("/fxml/History.fxml"));
                Scene scene = new Scene(root);
                scene.getStylesheets().add("/style/Style.css");
                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(scene);
                window.show();
            }
            catch(Exception e){
                showMessageDialog(null,e.getMessage());
            }
        }
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
        SpinnerValueFactory<Integer> valueFactorySistol=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryDiastol=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryPulse=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryGula=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        SpinnerValueFactory<Integer> valueFactoryBerat=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
//        SpinnerValueFactory<Integer> valueFactoryTinggi=new SpinnerValueFactory.IntegerSpinnerValueFactory(0,1000,0);
        spnSistol.setValueFactory(valueFactorySistol);
        spnDiastol.setValueFactory(valueFactoryDiastol);
        spnPulse.setValueFactory(valueFactoryPulse);
        spnGula.setValueFactory(valueFactoryGula);
        spnBerat.setValueFactory(valueFactoryBerat);
//        spnTinggi.setValueFactory(valueFactoryTinggi);
        
    }   
    
    public void initData(int idData){
        this.idData=idData;
        String sql="SELECT * FROM data WHERE id_data="+idData;
        try{
            Connection con=Db.connectDB();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            rs.next();
            spnSistol.getValueFactory().setValue(rs.getInt("sistol"));
            spnDiastol.getValueFactory().setValue(rs.getInt("diastol"));
            spnPulse.getValueFactory().setValue(rs.getInt("pulse"));
            spnGula.getValueFactory().setValue(rs.getInt("gula_darah"));
            spnBerat.getValueFactory().setValue(rs.getInt("berat"));
            LocalDate tanggal=LocalDate.parse(rs.getString("waktu_tambah"), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            dpTgl.setValue(tanggal);
//            spnTinggi.getValueFactory().setValue(rs.getInt("tinggi"));
            con.close();
        }
        catch(SQLException e){
            
        }
    }
    
}
