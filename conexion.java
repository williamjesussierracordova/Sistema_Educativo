/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.william.proyectoadd;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author WILLIAM
 */
public class conexion {
    Connection conectar=null;
    
    String user="usersql";
    String password="";
    String bd="maqueta_proyecto";
    String ip="localhost";
    String puerto="1433";
    
    String cadena="jdbc:sqlserver://"+ip+":"+puerto+"/"+bd;
    
    public Connection establecerConexion(){
        try{
            String cadena= "jdbc:sqlserver://localhost:"+puerto+";"+"databaseName="+bd+";"+"TrustServerCertificate=True";
            conectar= DriverManager.getConnection(cadena, user, password);
            System.out.println("Se conecto correctamente a la base de datos");
       
        } 
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error al conectar a la base de datos, error: " + e.toString());
        }
        return conectar;
    }
}
