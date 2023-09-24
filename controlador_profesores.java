/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.modelo_profesores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelos.modelo_grados;
/**
 *
 * @author WILLIAM
 */
public class controlador_profesores {
    
    
    
    public void crearRegistro(Connection connection,  modelo_profesores profesor) throws SQLException {
        String query = "INSERT INTO profesores VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, profesor.getProfesorID());
        statement.setString(2, profesor.getNombre());
        statement.setString(3, profesor.getApellido());
        statement.setString(4, profesor.getDireccion());
        statement.setString(5, profesor.getTelefono());
        statement.setString(6, profesor.getCorreo());
        statement.setString(7, profesor.getAreaEspecialidad());
        statement.setString(8, profesor.getFechaNacimiento());
        statement.setString(9, profesor.getFechaIngreso());
        statement.setFloat(10, profesor.getSalario());
        statement.setString(11, profesor.getEstado());

    
        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_profesores> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT * FROM profesores" ;
        ArrayList<modelo_profesores> profesores_array= new ArrayList();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            modelo_profesores profesores= new modelo_profesores();
            profesores.setProfesorID(resultSet.getString("profesorID"));
            profesores.setNombre(resultSet.getString("nombre"));
            profesores.setApellido(resultSet.getString("apellido"));
            profesores.setDireccion(resultSet.getString("direccion"));
            profesores.setTelefono(resultSet.getString("telefono"));
            profesores.setCorreo(resultSet.getString("correo"));
            profesores.setAreaEspecialidad(resultSet.getString("areaEspecialidad"));
            profesores.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
            profesores.setFechaIngreso(resultSet.getString("fechaIngreso"));
            profesores.setSalario(resultSet.getFloat("salario"));
            profesores.setEstado(resultSet.getString("estado"));
            
            profesores_array.add(profesores);
        }
        return profesores_array;
    }
    
    public modelo_profesores buscarRegistro(Connection connection, String valor1) throws SQLException {
    String query = "SELECT * FROM profesores WHERE profesorID=?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, valor1);
    ResultSet resultSet = statement.executeQuery();
    modelo_profesores profesor = new modelo_profesores();
    while (resultSet.next()) {
        profesor.setProfesorID(resultSet.getString("profesorID"));
        profesor.setNombre(resultSet.getString("nombre"));
        profesor.setApellido(resultSet.getString("apellido"));
        profesor.setDireccion(resultSet.getString("direccion"));
        profesor.setTelefono(resultSet.getString("telefono"));
        profesor.setCorreo(resultSet.getString("correo"));
        profesor.setAreaEspecialidad(resultSet.getString("areaEspecialidad"));
        profesor.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
        profesor.setFechaIngreso(resultSet.getString("fechaIngreso"));
        profesor.setSalario(resultSet.getFloat("salario"));
        profesor.setEstado(resultSet.getString("estado"));
    }
    return profesor;
}
    public ArrayList<modelo_grados> buscarTutoria(Connection connection, String valor1) throws SQLException {
    String query = "select * from grados where tutorID=?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, valor1);
    ResultSet resultSet = statement.executeQuery();
    ArrayList<modelo_grados> agrados= new ArrayList();
    while (resultSet.next()) {
        modelo_grados mg= new modelo_grados();
        mg.setGradoID(resultSet.getInt("gradoID"));
        mg.setGrado(resultSet.getInt("grado"));
        mg.setNivelID(resultSet.getInt("nivelID"));
        mg.setSeccion(resultSet.getString("seccion"));
        mg.setTutorID(resultSet.getString("tutorID"));
        mg.setCupos(resultSet.getInt("cupos"));
        
        agrados.add(mg);
    }
    return agrados;
}

    
    public boolean actualizarRegistro(Connection connection, modelo_profesores profesor) throws SQLException {
        String query = "UPDATE profesores SET nombre = ?, apellido = ?, direccion = ?, telefono = ?, correo = ?, areaEspecialidad = ?, fechaNacimiento = ?, fechaIngreso = ?, salario = ?, estado = ? WHERE profesorID = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, profesor.getNombre());
        statement.setString(2, profesor.getApellido());
        statement.setString(3, profesor.getDireccion());
        statement.setString(4, profesor.getTelefono());
        statement.setString(5, profesor.getCorreo());
        statement.setString(6, profesor.getAreaEspecialidad());
        statement.setString(7, profesor.getFechaNacimiento());
        statement.setString(8, profesor.getFechaIngreso());
        statement.setFloat(9, profesor.getSalario());
        statement.setString(10, profesor.getEstado());
        statement.setString(11, profesor.getProfesorID());

        int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
    }
    
}
