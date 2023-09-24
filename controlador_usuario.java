/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import modelos.modelo_usuario;
import modelos.modelo_grados;
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
public class controlador_usuario {
    private ArrayList<modelo_usuario> usuario_array = new ArrayList();
    
    public void crearRegistro(Connection connection, String valor1, String valor2, String valor3,String valor4) throws SQLException {
        String query = "INSERT INTO usuario (DNI,hashPassword,salt,tipoUsuario) VALUES ("+"'"+ valor1 +"'"+","+"'"+valor2 +"'"+ ","+"'"+valor3+"'"+","+"'"+valor4+"'"+")";
        PreparedStatement statement = connection.prepareStatement(query);
        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_usuario> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT DNI,tipoUsuario FROM usuario";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            modelo_usuario usuarios= new modelo_usuario();
            usuarios.setDNI(resultSet.getString("DNI"));
            usuarios.setTipoUsuario(resultSet.getString("tipoUsuario"));
            
            usuario_array.add(usuarios);
        }
        return usuario_array;
    }
    
    
    
    public modelo_usuario consultaDNI(Connection connection, String valor1) throws SQLException {
        String query = "SELECT DNI, hashPassword, salt, tipoUsuario FROM usuario WHERE DNI = '"+valor1+"';";
        modelo_usuario usuario;
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                usuario = null;
                if (resultSet.next()) {
                    String dni = resultSet.getString("DNI");
                    String hashPassword = resultSet.getString("hashPassword");
                    String salt = resultSet.getString("salt");
                    String tipoUsuario = resultSet.getString("tipoUsuario");
                    
                    // Crea un objeto modelo_usuario con los datos obtenidos
                    usuario = new modelo_usuario(dni, hashPassword, salt, tipoUsuario);
                }   // Cierra los recursos
            }
        }

        return usuario;
    }
    
    public boolean actualizarUsuarioDNI(Connection connection, modelo_usuario mu) throws SQLException {
    String query = "UPDATE usuario SET hashPassword = ?, salt = ?, tipoUsuario = ? WHERE DNI = ?";
    PreparedStatement statement = connection.prepareStatement(query);
    
    statement.setString(1, mu.getHash());
    statement.setString(2, mu.getSalt());
    statement.setString(3, mu.getTipoUsuario());
    statement.setString(4, mu.getDNI());
    
    int rowsUpdated = statement.executeUpdate();
            return rowsUpdated > 0;
    
    }
    
    public boolean eliminarUsuarioDNI(Connection connection, String dni) throws SQLException {
        String query = "DELETE FROM usuario WHERE DNI = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, dni);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }


}
