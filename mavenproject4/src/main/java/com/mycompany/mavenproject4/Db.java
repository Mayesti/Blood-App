/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mayesti
 */
public class Db {
    private Connection conn=null;
    public static Connection connectDB(){
        Connection con=null;
        try {
            String url = "jdbc:sqlite:logiin.db";
            con = DriverManager.getConnection(url);  
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return con;
    }
}


