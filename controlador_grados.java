/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.modelo_grados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.modelo_profesores;

/**
 *
 * @author WILLIAM
 */
public class controlador_grados {
    
    private ArrayList<modelo_grados> grados_array = new ArrayList();
    
    public void crearRegistro(Connection connection, int valor1, int valor2, String valor3,String valor4) throws SQLException {
        String query = "INSERT INTO grados (grado,nivelID,seccion,tutorID) VALUES ("+ valor1 +","+valor2 + ","+"'"+valor3+"'"+","+"'"+valor4+"'"+")";
        PreparedStatement statement = connection.prepareStatement(query);
        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_grados> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT gradoID,grado,nivelID,seccion,tutorID FROM grados";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            modelo_grados grados= new modelo_grados();
            grados.setGradoID(resultSet.getInt("gradoID"));
            grados.setGrado(resultSet.getInt("grado"));
            grados.setNivelID(resultSet.getInt("nivelID"));
            grados.setSeccion(resultSet.getString("seccion"));
            grados.setTutorID(resultSet.getString("tutorID"));
            
            grados_array.add(grados);
        }
        return grados_array;
    }
    
    public modelo_grados buscarRegistro(Connection connection, int valor1) throws SQLException {
        String query = "SELECT * FROM grados WHERE gradoID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, valor1);
        ResultSet resultSet = statement.executeQuery();
        modelo_grados mg= new modelo_grados();
        while (resultSet.next()) {
            mg.setGradoID(resultSet.getInt("gradoID"));
            mg.setGrado(resultSet.getInt("grado"));
            mg.setNivelID(resultSet.getInt("nivelID"));
            mg.setSeccion(resultSet.getString("seccion"));
            mg.setTutorID(resultSet.getString("tutorID"));
            mg.setCupos(resultSet.getInt("cupos"));

        }
        return mg;
    }
}
