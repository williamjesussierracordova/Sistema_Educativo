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
import modelos.modelo_calificaciones;
import modelos.modelo_estudiantes;
import modelos.modelo_salones;

/**
 *
 * @author WILLIAM
 */
public class controlador_calificaciones {
    
    
    public void crearRegistro(Connection connection,  modelo_calificaciones calificacion) throws SQLException {
        String query = "INSERT INTO calificaciones VALUES (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, calificacion.getEstudianteID());
        statement.setInt(2, calificacion.getMateriaID());
        statement.setString(3, calificacion.getProfesorID());
        statement.setString(4, calificacion.getDescripcionEvaluacion());
        statement.setInt(5, calificacion.getCalificacion());

        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_calificaciones> CalificacionesDni(Connection connection,String dni) throws SQLException{
        String query =" SELECT * from calificaciones where estudianteID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, dni);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<modelo_calificaciones> acalificaciones= new ArrayList();
        while (resultSet.next()) {
            modelo_calificaciones mc=new modelo_calificaciones();
            mc.setEstudianteID(resultSet.getString("estudianteID"));
            mc.setCalificacion(resultSet.getInt("calificacion"));
            mc.setDescripcionEvaluacion(resultSet.getString("descripcionEvaluacion"));
            mc.setMateriaID(resultSet.getInt("materiaID"));
            mc.setProfesorID(resultSet.getString("profesorID"));
            acalificaciones.add(mc);
        }
        return  acalificaciones;
    }
    
    public boolean actualizarCalificacion(Connection connection, modelo_calificaciones calificacion) throws SQLException {
        String query = "UPDATE calificaciones SET calificacion=? WHERE estudianteID=? and materiaID=? and profesorID=? and descripcionEvaluacion=?";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setInt(1, calificacion.getCalificacion());
        statement.setString(2,calificacion.getEstudianteID());
        statement.setInt(3,calificacion.getMateriaID());
        statement.setString(4,calificacion.getProfesorID());
        statement.setString(5, calificacion.getDescripcionEvaluacion());
        
        int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
    }
    
}
