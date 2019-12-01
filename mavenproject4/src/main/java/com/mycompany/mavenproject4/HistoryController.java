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
import java.util.List;
import java.util.ArrayList;
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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
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
    
    ObservableList<DataRiwayat> data = FXCollections.observableArrayList();
    
    ObservableList<DataRiwayat> listHasilPencarian = FXCollections.observableArrayList();
    
    @FXML
    private TextField tfCari;
    
    @FXML
    private RadioButton rbTanggal;
    
    @FXML
    private RadioButton rbDiagnosa;
    
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
    private TableColumn<DataRiwayat,String> columnDiagnosaTekananDarah;
    
    @FXML
    private TableColumn<DataRiwayat,String> columnDiagnosaGulaDarah;
    
    private List<Integer> listIdData;
    
    @FXML
    private void btnEditProfil(ActionEvent event){
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/editProfil.fxml"));
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
    private void btnUbahPass(ActionEvent event){
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/ubahPassword.fxml"));
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
    private void btnLogout(ActionEvent event){
       try {
            Parent root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    private void loadData(){
        try{
            
            String sql="SELECT * FROM data WHERE username='"+UserLogin.username+"'";
            Connection con=Db.connectDB();
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            while(rs.next()){
                listIdData.add(rs.getInt("id_data"));
                String tanggal=rs.getString("waktu_tambah");
                int sistolik=rs.getInt("sistol");
                int diastolik=rs.getInt("diastol");
                int pulse=rs.getInt("pulse");
                int gulaDarah=rs.getInt("gula_darah");
                int berat=rs.getInt("berat");
                String diagnosaTekananDarah=null;
                String diagnosaGulaDarah=null;
                if(sistolik<90 || diastolik<60)
                    diagnosaTekananDarah="Hipotensi";
                else if((sistolik>=90 && sistolik<140) || (diastolik>=60 && diastolik<90))
                    diagnosaTekananDarah="Normal";
                else if(sistolik>=140 || diastolik>=90)
                    diagnosaTekananDarah="Hipertensi";
                if(gulaDarah<70)
                    diagnosaGulaDarah="Hipoglikemia";
                else if(gulaDarah>=70 && gulaDarah<=200)
                    diagnosaGulaDarah="Normal";
                else if(gulaDarah>200)
                    diagnosaGulaDarah="Hiperglikemia";
                data.add(new DataRiwayat(tanggal,sistolik,diastolik,pulse,gulaDarah,berat,diagnosaTekananDarah,diagnosaGulaDarah));
            }
            tvRiwayat.setItems(data);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
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
    
    @FXML
    private void btnEditOnAction(ActionEvent event) {
        int selectedRowIdx=tvRiwayat.getSelectionModel().getSelectedIndex();
        int idData=listIdData.get(selectedRowIdx);
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/editData.fxml"));
            Scene scene = new Scene((Parent)root.load());
            scene.getStylesheets().add("/style/Style.css");
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            EditDataController editDataController=root.getController();
            editDataController.initData(idData);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    @FXML
    private void btnHapusOnAction(ActionEvent event){
        int dialogResult=JOptionPane.showOptionDialog(null,"Apakah anda yakin akan menghapus data yang terpilih?","Konfirmasi Hapus Data",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,null,null);
        if(dialogResult==JOptionPane.YES_OPTION){
            int selectedRowIdx=tvRiwayat.getSelectionModel().getSelectedIndex();
            String sql="DELETE FROM data WHERE id_data="+Integer.toString(listIdData.get(selectedRowIdx));
            try{
                Connection con=Db.connectDB();
                Statement stmt=con.createStatement();
                stmt.executeUpdate(sql);
                con.close();
                listIdData.remove(selectedRowIdx);
                loadData();
            }
            catch(SQLException e){
                showMessageDialog(null,e.getMessage());
            }
        }
    }
    @FXML
    private void btnHasilAnalisis(ActionEvent event){
        int selectedRowIdx=tvRiwayat.getSelectionModel().getSelectedIndex();
        String diagnosaTekananDarah=columnDiagnosaTekananDarah.getCellObservableValue(selectedRowIdx).getValue();
        String diagnosaGulaDarah=columnDiagnosaGulaDarah.getCellObservableValue(selectedRowIdx).getValue();
        try {
            FXMLLoader root = new FXMLLoader(getClass().getResource("/fxml/analisisData.fxml"));
            Scene scene = new Scene((Parent)root.load());
            scene.getStylesheets().add("/style/Style.css");
            AnalisisDataController analisisDataController=root.getController();
            analisisDataController.initDiagnosaData(diagnosaTekananDarah,diagnosaGulaDarah);
            Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();
        } catch(Exception e) {
            showMessageDialog(null,e.getMessage());
        }
    }
    
    @FXML
    private void btnCariOnAction(ActionEvent event){
        listHasilPencarian.clear();
        if(rbTanggal.isSelected()){
            String keyword=tfCari.getText();
            for(int i=0;i<data.size();i++){
                String tmpTanggal=data.get(i).getTanggal();
                if(tmpTanggal.contains(keyword))
                    listHasilPencarian.add(data.get(i));
            }
            tvRiwayat.setItems(listHasilPencarian);
        }
        else if(rbDiagnosa.isSelected()){
            String keyword=tfCari.getText();
            keyword=keyword.substring(0,1).toUpperCase() + keyword.substring(1).toLowerCase();
            for(int i=0;i<data.size();i++){
                String tmpDiagnosaTekananDarah=data.get(i).getDiagnosaTekananDarah();
                String tmpDiagnosaGulaDarah=data.get(i).getDiagnosaGulaDarah();
                if(tmpDiagnosaTekananDarah.contains(keyword) || tmpDiagnosaGulaDarah.contains(keyword))
                    listHasilPencarian.add(data.get(i));
            }
            tvRiwayat.setItems(listHasilPencarian);
        }
    }
    
    @FXML
    private void btnRefreshOnAction(ActionEvent event){
        tvRiwayat.setItems(data);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listIdData=new ArrayList<Integer>();
        columnTanggal.setCellValueFactory(new PropertyValueFactory<DataRiwayat,String>("tanggal"));
        columnSistolik.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("sistolik"));
        columnDiastolik.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("diastolik"));
        columnPulse.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("pulse"));
        columnKadarGulaDarah.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("gulaDarah"));
        columnBeratBadan.setCellValueFactory(new PropertyValueFactory<DataRiwayat,Integer>("beratBadan"));
        columnDiagnosaTekananDarah.setCellValueFactory(new PropertyValueFactory<DataRiwayat,String>("diagnosaTekananDarah"));
        columnDiagnosaGulaDarah.setCellValueFactory(new PropertyValueFactory<DataRiwayat,String>("diagnosaGulaDarah"));
        ToggleGroup grupRbJenisPencarian=new ToggleGroup();
        rbTanggal.setToggleGroup(grupRbJenisPencarian);
        rbDiagnosa.setToggleGroup(grupRbJenisPencarian);
        rbTanggal.setSelected(true);
        loadData();
    }    
    
}
