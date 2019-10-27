/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject4;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Mayesti
 */
public class Db {
    
//    private Db(){
//        
//    }

    /**
     *
     * @return
     */
    public Db getInstance() {
        return new Db();
    }
    
    private Connection conn = null;
    
    public void Connection(String user, String pass){ 
        try {
            String url = "jdbc:sqlite:logiin.db";
            conn = DriverManager.getConnection(url);
            Statement p = conn.createStatement();
            System.out.println(user);
            System.out.println(pass);
            String query = "select *from user WHERE username = "+user+" AND password = "+pass+"";
            
            
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally{
            try{
                if(conn != null){
                    conn.close();
                }
            }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        }
//            Class.forName("org.sqlite.JDBC");
//            Connection conn =DriverManager.getConnection("jdbc:sqlite:logiin.db");
//            return conn;
//        } catch (Exception e) {
//            System.out.println(e);
//            return null;
//            // TODO: handle exception
//        }
    }

    Connection Connection(Type String) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}


