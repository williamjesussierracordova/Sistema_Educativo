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
import modelos.modelo_niveles;
import modelos.modelo_salones;

/**
 *
 * @author WILLIAM
 */
public class controlador_materias {
    public void crearRegistro(Connection connection,modelo_materias materias) throws SQLException {
        String query = "INSERT INTO materias (nombreMateria) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, materias.getNombreMateria());

        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_materias> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT materiaID,nombreMateria FROM materias" ;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<modelo_materias> materias_array= new ArrayList();
        while (resultSet.next()) {
            modelo_materias materias= new modelo_materias();
            materias.setMateriaID(resultSet.getInt("materiaID"));
            materias.setNombreMateria(resultSet.getString("nombreMateria"));
            
            materias_array.add(materias);
        }
        return materias_array;
    }
    
    public int buscarMateria(Connection connection,String valor) throws SQLException{
        String query = "SELECT materiaID FROM materias WHERE nombreMateria=?" ;
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, valor);
        
        ResultSet resultSet = statement.executeQuery();
        modelo_materias materias= new modelo_materias();
        while (resultSet.next()) {
            materias.setMateriaID(resultSet.getInt("materiaID"));
        }
        return materias.getMateriaID();
    }
    
    public String buscarMaterias(Connection connection,int valor) throws SQLException{
        String query = "SELECT nombreMateria FROM materias WHERE materiaID=?" ;
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setInt(1, valor);
        
        ResultSet resultSet = statement.executeQuery();
        modelo_materias materias= new modelo_materias();
        while (resultSet.next()) {
            materias.setNombreMateria(resultSet.getString("nombreMateria"));
        }
        return materias.getNombreMateria();
    }
    
    public boolean eliminarMateria(Connection connection, String materia) throws SQLException {
        String query = "DELETE FROM materias WHERE nombreMateria = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, materia);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
}
