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
import modelos.modelo_cursosGrado;
import modelos.modelo_profesores;

/**
 *
 * @author WILLIAM
 */
public class controlador_cursosGrado {
    public ArrayList<modelo_cursosGrado> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT * FROM cursosXgrado" ;
        ArrayList<modelo_cursosGrado> ac= new ArrayList();
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            modelo_cursosGrado cg= new modelo_cursosGrado();
            cg.setGradoID(resultSet.getInt("gradoID"));
            cg.setGrado(resultSet.getInt("grado"));
            cg.setNivel(resultSet.getInt("nivel"));
            cg.setCurso1(resultSet.getInt("curso1"));
            cg.setCurso2(resultSet.getInt("curso2"));
            cg.setCurso3(resultSet.getInt("curso3"));
            cg.setCurso4(resultSet.getInt("curso4"));
            cg.setCurso5(resultSet.getInt("curso5"));
            cg.setCurso6(resultSet.getInt("curso6"));
            cg.setCurso7(resultSet.getInt("curso7"));
            cg.setCurso8(resultSet.getInt("curso8"));
            cg.setCurso9(resultSet.getInt("curso9"));
            cg.setCurso10(resultSet.getInt("curso10"));
            cg.setCurso11(resultSet.getInt("curso11"));
            cg.setCurso12(resultSet.getInt("curso12"));
            cg.setCurso13(resultSet.getInt("curso13"));
            cg.setCurso14(resultSet.getInt("curso14"));
            cg.setCurso15(resultSet.getInt("curso15"));
            
            ac.add(cg);
        }
        return ac;
    }
    
    public modelo_cursosGrado buscarRegistro(Connection connection, int valor1) throws SQLException {
    String query = "SELECT * FROM cursosXgrado WHERE gradoID=?";
    PreparedStatement statement = connection.prepareStatement(query);
    statement.setInt(1, valor1);
    ResultSet resultSet = statement.executeQuery();
    modelo_cursosGrado cg = new modelo_cursosGrado();
    while (resultSet.next()) {
        cg.setGradoID(resultSet.getInt("gradoID"));
            cg.setGrado(resultSet.getInt("grado"));
            cg.setNivel(resultSet.getInt("nivel"));
            cg.setCurso1(resultSet.getInt("curso1"));
            cg.setCurso2(resultSet.getInt("curso2"));
            cg.setCurso3(resultSet.getInt("curso3"));
            cg.setCurso4(resultSet.getInt("curso4"));
            cg.setCurso5(resultSet.getInt("curso5"));
            cg.setCurso6(resultSet.getInt("curso6"));
            cg.setCurso7(resultSet.getInt("curso7"));
            cg.setCurso8(resultSet.getInt("curso8"));
            cg.setCurso9(resultSet.getInt("curso9"));
            cg.setCurso10(resultSet.getInt("curso10"));
            cg.setCurso11(resultSet.getInt("curso11"));
            cg.setCurso12(resultSet.getInt("curso12"));
            cg.setCurso13(resultSet.getInt("curso13"));
            cg.setCurso14(resultSet.getInt("curso14"));
            cg.setCurso15(resultSet.getInt("curso15"));
    }
    return cg;
}
}
