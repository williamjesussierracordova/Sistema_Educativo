/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.modelo_estudiantes;
import modelos.modelo_profesores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author WILLIAM
 */
public class controlador_estudiantes {
    private ArrayList<modelo_estudiantes> estudiantes_array= new ArrayList();
    
    
    
    public void crearRegistro(Connection connection, modelo_estudiantes estudiante) throws SQLException {
    String query = "INSERT INTO estudiantes VALUES (?,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    PreparedStatement statement = connection.prepareStatement(query);
    
    statement.setString(1, estudiante.getEstudianteID());
    statement.setString(2, estudiante.getNombre());
    statement.setString(3, estudiante.getApellido());
    statement.setString(4, estudiante.getFechaNacimiento());
    statement.setString(5, estudiante.getDireccion());
    statement.setString(6, estudiante.getTelefono());
    statement.setString(7, estudiante.getNombreApoderado());
    statement.setString(8, estudiante.getApellidoApoderado());
    statement.setString(9, estudiante.getParentescoApoderado());
    statement.setString(10, estudiante.getTelefonoApoderado());
    statement.setString(11, estudiante.getDireccionApoderado());
    statement.setString(12, estudiante.getFechaInscripcion());
    statement.setString(13, estudiante.getEstadoEstudiante());
    statement.setString(14, estudiante.getCorreo());
    statement.setString(15, estudiante.getSexo());
    statement.setString(16, estudiante.getCorreoApoderado());
    statement.setString(17,estudiante.getFechaActualizacion());
    
    int rowsInserted = statement.executeUpdate();
    JOptionPane.showMessageDialog(null, rowsInserted + " registro(s) creado(s)");
}


    
    public ArrayList<modelo_estudiantes> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT estudianteID,nombre,apellido,fechaNacimiento,direccion,telefono,nombreApoderado,apellidoApoderado,parentescoApoderado,telefonoApoderado,direccionApoderado,fechaInscripcion,estadoEstudiante,correo,sexo,correoApoderado FROM estudiantes" ;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            modelo_estudiantes estudiantes= new modelo_estudiantes();
            estudiantes.setEstudianteID(resultSet.getString("estudianteID"));
            estudiantes.setNombre(resultSet.getString("nombre"));
            estudiantes.setApellido(resultSet.getString("apellido"));
            estudiantes.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
            estudiantes.setDireccion(resultSet.getString("direccion"));
            estudiantes.setTelefono(resultSet.getString("telefono"));
            estudiantes.setNombreApoderado(resultSet.getString("nombreApoderado"));
            estudiantes.setApellidoApoderado(resultSet.getString("apellidoApoderado"));
            estudiantes.setParentescoApoderado(resultSet.getString("parentescoApoderado"));
            estudiantes.setTelefonoApoderado(resultSet.getString("telefonoApoderado"));
            estudiantes.setDireccionApoderado(resultSet.getString("direccionApoderado"));
            estudiantes.setFechaInscripcion(resultSet.getString("fechaInscripcion"));
            estudiantes.setEstadoEstudiante("estadoEstudiante");
            estudiantes.setCorreo("correo");
            estudiantes.setSexo("sexo");
            estudiantes.setCorreoApoderado("correoApoderado");
            
            estudiantes_array.add(estudiantes);
        }
        return estudiantes_array;
    }
    
    public modelo_estudiantes buscarRegistro(Connection connection, String valor1) throws SQLException {
    String query = "SELECT estudianteID, nombre, apellido, fechaNacimiento, direccion, telefono, nombreApoderado, apellidoApoderado, parentescoApoderado, telefonoApoderado, direccionApoderado, fechaInscripcion, estadoEstudiante, correo, sexo, correoApoderado FROM estudiantes WHERE estudianteID = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setString(1, valor1);
    ResultSet resultSet = statement.executeQuery();
    modelo_estudiantes estudiantes = new modelo_estudiantes(); 
    while (resultSet.next()) {
        estudiantes.setEstudianteID(resultSet.getString("estudianteID"));
        estudiantes.setNombre(resultSet.getString("nombre"));
        estudiantes.setApellido(resultSet.getString("apellido"));
        estudiantes.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
        estudiantes.setDireccion(resultSet.getString("direccion"));
        estudiantes.setTelefono(resultSet.getString("telefono"));
        estudiantes.setNombreApoderado(resultSet.getString("nombreApoderado"));
        estudiantes.setApellidoApoderado(resultSet.getString("apellidoApoderado"));
        estudiantes.setParentescoApoderado(resultSet.getString("parentescoApoderado"));
        estudiantes.setTelefonoApoderado(resultSet.getString("telefonoApoderado"));
        estudiantes.setDireccionApoderado(resultSet.getString("direccionApoderado"));
        estudiantes.setFechaInscripcion(resultSet.getString("fechaInscripcion"));
        estudiantes.setEstadoEstudiante(resultSet.getString("estadoEstudiante"));
        estudiantes.setCorreo(resultSet.getString("correo"));
        estudiantes.setSexo(resultSet.getString("sexo"));
        estudiantes.setCorreoApoderado(resultSet.getString("correoApoderado"));
    }
    return estudiantes;
}

    
    public modelo_estudiantes buscarRegistroActivo(Connection connection,String valor1) throws SQLException{
        String query = "SELECT estudianteID,nombre,apellido,fechaNacimiento,direccion,telefono,nombreApoderado,apellidoApoderado,parentescoApoderado,telefonoApoderado,direccionApoderado,fechaInscripcion,estadoEstudiante,correo,sexo,correoApoderado FROM estudiantes WHERE estudianteID= "+valor1+" and estadoEstudiante='Activo'";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        modelo_estudiantes estudiantes= new modelo_estudiantes();
        while (resultSet.next()) {
            estudiantes.setEstudianteID(resultSet.getString("estudianteID"));
            estudiantes.setNombre(resultSet.getString("nombre"));
            estudiantes.setApellido(resultSet.getString("apellido"));
            estudiantes.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
            estudiantes.setDireccion(resultSet.getString("direccion"));
            estudiantes.setTelefono(resultSet.getString("telefono"));
            estudiantes.setNombreApoderado(resultSet.getString("nombreApoderado"));
            estudiantes.setApellidoApoderado(resultSet.getString("apellidoApoderado"));
            estudiantes.setParentescoApoderado(resultSet.getString("parentescoApoderado"));
            estudiantes.setTelefonoApoderado(resultSet.getString("telefonoApoderado"));
            estudiantes.setDireccionApoderado(resultSet.getString("direccionApoderado"));
            estudiantes.setFechaInscripcion(resultSet.getString("fechaInscripcion"));
            estudiantes.setEstadoEstudiante(resultSet.getString("estadoEstudiante"));
            estudiantes.setCorreo(resultSet.getString("correo"));
            estudiantes.setSexo(resultSet.getString("sexo"));
            estudiantes.setCorreoApoderado(resultSet.getString("correoApoderado"));
        }
        return estudiantes;
    }
    
    
    public boolean actualizarRegistro(Connection connection, modelo_estudiantes estudiante) throws SQLException {
        String query = "UPDATE estudiantes SET nombre = ?, apellido = ?, fechaNacimiento = ?, direccion = ?, telefono = ?, nombreApoderado = ?, apellidoApoderado = ?, parentescoApoderado = ?, telefonoApoderado = ?, direccionApoderado = ?, fechaInscripcion = ? , estadoEstudiante=?, sexo=?,correo=?,correoApoderado=?,fechaActualizacion=? WHERE estudianteID = ?";
        PreparedStatement statement = connection.prepareStatement(query);

        statement.setString(1, estudiante.getNombre());
        statement.setString(2, estudiante.getApellido());
        statement.setString(3, estudiante.getFechaNacimiento());
        statement.setString(4, estudiante.getDireccion());
        statement.setString(5, estudiante.getTelefono());
        statement.setString(6, estudiante.getNombreApoderado());
        statement.setString(7, estudiante.getApellidoApoderado());
        statement.setString(8, estudiante.getParentescoApoderado());
        statement.setString(9, estudiante.getTelefonoApoderado());
        statement.setString(10, estudiante.getDireccionApoderado());
        statement.setString(11, estudiante.getFechaInscripcion());
        statement.setString(12, estudiante.getEstadoEstudiante());
        statement.setString(13, estudiante.getSexo());
        statement.setString(14, estudiante.getCorreo());
        statement.setString(15, estudiante.getCorreoApoderado());
        statement.setString(16, estudiante.getFechaActualizacion());
        statement.setString(17, estudiante.getEstudianteID());

        int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
    }
    
    
}
