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
import modelos.modelo_asistencias;
import modelos.modelo_estudiantes;

/**
 *
 * @author WILLIAM
 */
public class controlador_asistencias {
    public void crearRegistro(Connection connection,modelo_asistencias asistencia) throws SQLException {
        String query = "INSERT INTO asistencias VALUES (?,?,?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, asistencia.getEstudianteID());
        statement.setString(2, asistencia.getFecha());
        statement.setString(3, asistencia.getAsistencia());

        int rowsInserted = statement.executeUpdate();
        
    }
    
   public ArrayList<modelo_estudiantes> obtenerAlumnosSinAsistencia(Connection conn, String fecha) throws SQLException {
    ArrayList<modelo_estudiantes> alumnosSinAsistencia = new ArrayList();

    String sql = "SELECT estudianteID FROM estudiantes WHERE estadoEstudiante='Activo' AND estudianteID NOT IN (SELECT estudianteID FROM asistencias WHERE fecha =?) ";

    try (PreparedStatement stmt = conn.prepareStatement(sql)) {
        stmt.setString(1, fecha);

        try (ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                modelo_estudiantes me= new modelo_estudiantes();
                String alumnoId = rs.getString("estudianteID");
                me.setEstudianteID(alumnoId);
                alumnosSinAsistencia.add(me);
            }
        }
    }

    return alumnosSinAsistencia;
}

   public ArrayList<modelo_asistencias> AsistenciasRegistradas(Connection connection,String dni) throws SQLException{
       String query="  SELECT * FROM asistencias WHERE estudianteID=?";
       PreparedStatement statement = connection.prepareStatement(query);
       statement.setString(1, dni);
       ResultSet resultSet = statement.executeQuery();
       ArrayList<modelo_asistencias> asistencias_array= new ArrayList();
       while(resultSet.next()){
           modelo_asistencias ms=new modelo_asistencias();
           ms.setEstudianteID(resultSet.getString("estudianteID"));
           ms.setFecha(resultSet.getString("fecha"));
           ms.setAsistencia(resultSet.getString("asistencia"));
           
           asistencias_array.add(ms);
       }
       return asistencias_array;
   }
}
