/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.modelo_materias;
import modelos.modelo_profesores;
import modelos.modelo_salones;

/**
 *
 * @author WILLIAM
 */
public class controlador_salones {
    
    public void crearRegistro(Connection connection,  modelo_salones salon) throws SQLException {
        String query = "INSERT INTO salones(nombreSalon)VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, salon.getNombreSalon());


        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_salones> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT * FROM salones" ;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<modelo_salones> salones_array= new ArrayList();
        while (resultSet.next()) {
            modelo_salones salones= new modelo_salones();
            salones.setSalonID(resultSet.getInt("salonID"));
            salones.setNombreSalon(resultSet.getString("nombreSalon"));
            
            salones_array.add(salones);
        }
        return salones_array;
    }
    
    public boolean eliminarSalon(Connection connection, String salon) throws SQLException {
        String query = "DELETE FROM salones WHERE nombreSalon = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, salon);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
    
    public int buscarSalon(Connection connection,String valor) throws SQLException{
        String query = "SELECT salonID FROM salones WHERE nombreSalon=?" ;
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, valor);
        
        ResultSet resultSet = statement.executeQuery();
        modelo_salones salon= new modelo_salones();
        while (resultSet.next()) {
            salon.setSalonID(resultSet.getInt("salonID"));
        }
        return salon.getSalonID();
    }
    
    public String buscarSalones(Connection connection,int valor) throws SQLException{
        String query = "SELECT nombreSalon FROM salones WHERE salonID=?" ;
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setInt(1, valor);
        
        ResultSet resultSet = statement.executeQuery();
        modelo_salones salon= new modelo_salones();
        while (resultSet.next()) {
            salon.setNombreSalon(resultSet.getString("nombreSalon"));
        }
        return salon.getNombreSalon();
    }
}
