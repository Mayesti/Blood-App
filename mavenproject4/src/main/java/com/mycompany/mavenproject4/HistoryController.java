package com.mycompany.mavenproject4;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 * FXML Controller class
 *
 * @author My Computer
 */
public class HistoryController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<DataRiwayat> tvRiwayat;
    
    @FXML
    private TableColumn<DataRiwayat,String> columnTanggal;
    
    @FXML
    private TableColumn<DataRiwayat,Integer> columnSistolik;
    
    @FXML
    private TableColumn<DataRiwayat,Integer> columnDiastolik;
    
    @FXML
    private TableColumn<DataRiwayat,Integer> columnPulse;
    
    @FXML
    private TableColumn<DataRiwayat,Integer> columnKadarGulaDarah;
    
    @FXML
    private TableColumn<DataRiwayat,Integer> columnBeratBadan;
    
    @FXML
    private TableColumn<DataRiwayat,Integer> columnTinggiBadan;
    
    
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
    
    @FXML
    private void btnEditOnAction(ActionEvent event) {
        int selectedRowIdx=tvRiwayat.getSelectionModel().getSelectedIndex();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/editData.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            EditDataController editDataController=root.getController();
            
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try{
            columnTanggal.setCellValueFactory(new PropertyValueFactory<DataRiwayat,String>("tanggal"));
            columnSistolik.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("sistolik"));
            columnDiastolik.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("diastolik"));
            columnPulse.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("pulse"));
            columnKadarGulaDarah.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("gulaDarah"));
            columnBeratBadan.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("beratBadan"));
            columnTinggiBadan.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("tinggiBadan"));
            ObservableList<DataRiwayat> data = FXCollections.observableArrayList();
            String sql="SELECT * FROM data WHERE username='"+UserLogin.username+"'";
            Connection con=Db.connectDB();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                String tanggal=rs.getString("waktu_tambah");
                int sistolik=rs.getInt("sistol");
                int diastolik=rs.getInt("diastol");
                int pulse=rs.getInt("pulse");
                int gulaDarah=rs.getInt("gula_darah");
                int berat=rs.getInt("berat");
                int tinggi=rs.getInt("tinggi");
                data.add(new DataRiwayat(tanggal,sistolik,diastolik,pulse,gulaDarah,berat,tinggi));
            }
            tvRiwayat.setItems(data);
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
    
}
