/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controladores;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import modelos.modelo_horarios;
import java.sql.Time;
import java.util.ArrayList;
import modelos.modelo_materias;

/**
 *
 * @author WILLIAM
 */
public class controlador_horarios {
    
    public void crearRegistro(Connection connection,modelo_horarios horario) throws SQLException {
        String query = "INSERT INTO horarios (horaInicio,horaFinal,materiaID,profesorID,gradoID,salonID,Dia) VALUES (?,?,?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, horario.getHoraInicio());
        statement.setString(2, horario.getHoraFinal());
        statement.setInt(3, horario.getMateriaID());
        statement.setString(4, horario.getProfesorID());
        statement.setInt(5, horario.getGradoID());
        statement.setInt(6, horario.getSalonID());
        statement.setString(7, horario.getDia());

        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }
    
    public ArrayList<modelo_horarios> leerRegistros(Connection connection) throws SQLException {
        String query = "SELECT * FROM horarios" ;
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<modelo_horarios> ha= new ArrayList();
        while (resultSet.next()) {
            modelo_horarios horarios= new modelo_horarios();
            horarios.setHorarioID(resultSet.getInt("horarioID"));
            horarios.setHoraInicio(resultSet.getString("horaInicio"));
            horarios.setHoraFinal(resultSet.getString("horaFinal"));
            horarios.setMateriaID(resultSet.getInt("materiaID"));
            horarios.setProfesorID(resultSet.getString("profesorID"));
            horarios.setGradoID(resultSet.getInt("gradoID"));
            horarios.setSalonID(resultSet.getInt("salonID"));
            horarios.setDia(resultSet.getString("Dia"));

            ha.add(horarios);
        }
        return ha;
    }
    
    public boolean eliminarHorarios(Connection connection, String horario) throws SQLException {
        String query = "DELETE FROM horarios WHERE horarioID = ?";

        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, horario);

            int rowsDeleted = statement.executeUpdate();
            return rowsDeleted > 0;
        }
    }
    
    public modelo_horarios buscarHorario(Connection connection,int horarioID) throws SQLException{
        String query="SELECT * FROM horarios WHERE horarioID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, horarioID);
        ResultSet resultSet = statement.executeQuery();
        modelo_horarios mh= new modelo_horarios();
        while (resultSet.next()) {
            mh.setHorarioID(resultSet.getInt("horarioID"));
            mh.setHoraInicio(resultSet.getString("horaInicio"));
            mh.setHoraFinal(resultSet.getString("horaFInal"));
            mh.setMateriaID(resultSet.getInt("materiaID"));
            mh.setProfesorID(resultSet.getString("profesorID"));
            mh.setGradoID(resultSet.getInt("gradoID"));
            mh.setSalonID(resultSet.getInt("salonID"));
            mh.setDia(resultSet.getString("Dia"));
        }
        return mh;
    }
    
    public ArrayList<modelo_horarios> buscarHorarioProfesor(Connection connection,String profesorID) throws SQLException{
        String query="SELECT * FROM horarios WHERE profesorID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, profesorID);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<modelo_horarios> amh=new ArrayList();
        while (resultSet.next()) {
            modelo_horarios mh= new modelo_horarios();
            mh.setHorarioID(resultSet.getInt("horarioID"));
            mh.setHoraInicio(resultSet.getString("horaInicio"));
            mh.setHoraFinal(resultSet.getString("horaFInal"));
            mh.setMateriaID(resultSet.getInt("materiaID"));
            mh.setProfesorID(resultSet.getString("profesorID"));
            mh.setGradoID(resultSet.getInt("gradoID"));
            mh.setSalonID(resultSet.getInt("salonID"));
            mh.setDia(resultSet.getString("Dia"));
            
            amh.add(mh);
        }
        return amh;
    }
    
}
