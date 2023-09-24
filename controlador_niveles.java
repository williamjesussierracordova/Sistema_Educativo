/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.modelo_niveles;
import modelos.modelo_profesores;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author WILLIAM
 */
public class controlador_niveles {
    
    private ArrayList <modelo_niveles> niveles_array= new ArrayList();
    
    public ArrayList<modelo_niveles> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT nivelID,nombreNivel FROM niveles" ;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            modelo_niveles niveles= new modelo_niveles();
            niveles.setNivelID(resultSet.getInt("nivelID"));
            niveles.setNombreNivel(resultSet.getString("nombreNivel"));
            
            niveles_array.add(niveles);
        }
        return niveles_array;
    }
    
}
