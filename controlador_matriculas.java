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
import modelos.modelo_estudiantes;
import modelos.modelo_matriculas;
import modelos.modelo_profesores;

/**
 *
 * @author WILLIAM
 */
public class controlador_matriculas {
    /*public void crearRegistro(Connection connection,  modelo_matriculas matriculas, int gradoID) throws SQLException {
        String query = "INSERT INTO matriculas VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String query1 = "update grados set cupos=cupos-1 where gradoID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        PreparedStatement statement1 = connection.prepareStatement(query1);
        
        statement.setString(1, matriculas.getEstudianteID());
        statement.setInt(2, matriculas.getGradoID());
        statement.setInt(3, matriculas.getHorario1());
        statement.setInt(4, matriculas.getHorario2());
        statement.setInt(5, matriculas.getHorario3());
        statement.setInt(6, matriculas.getHorario4());
        statement.setInt(7, matriculas.getHorario5());
        statement.setInt(8, matriculas.getHorario6());
        statement.setInt(9, matriculas.getHorario7());
        statement.setInt(10, matriculas.getHorario8());
        statement.setInt(11, matriculas.getHorario9());
        statement.setInt(12, matriculas.getHorario10());
        statement.setInt(13, matriculas.getHorario11());
        statement.setInt(14, matriculas.getHorario12());
        statement.setInt(15, matriculas.getHorario13());
        statement.setInt(16, matriculas.getHorario14());
        statement.setInt(17, matriculas.getHorario15());
        statement.setInt(18, matriculas.getHorario16());
        statement.setInt(19, matriculas.getHorario17());
        statement.setInt(20, matriculas.getHorario18());
        statement.setInt(21, matriculas.getHorario19());
        statement.setInt(22, matriculas.getHorario20());
        statement.setInt(23, matriculas.getHorario21());
        statement.setInt(24, matriculas.getHorario22());
        statement.setInt(25, matriculas.getHorario23());
        statement.setInt(26, matriculas.getHorario24());
        statement.setInt(27, matriculas.getHorario25());
        statement1.setInt(1, gradoID);

    
    }*/
    
    public boolean crearRegistroSecundaria(Connection connection, modelo_matriculas matriculas, int gradoID) throws SQLException {
    String insertQuery = "INSERT INTO matriculas (estudianteID,gradoID,horario1, horario2, horario3, horario4, horario5, horario6, horario7, horario8, horario9, horario10, horario11, horario12, horario13, horario14, horario15, horario16, horario17, horario18, horario19, horario20, horario21, horario22, horario23) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String updateQuery = "UPDATE grados SET cupos = cupos - 1 WHERE gradoID = ?";
    
    PreparedStatement insertStatement = null;
    PreparedStatement updateStatement = null;

    try {
        // Iniciar la transacción
        connection.setAutoCommit(false);

        // Inserción en matriculas
        insertStatement = connection.prepareStatement(insertQuery);
        insertStatement.setString(1, matriculas.getEstudianteID());
        insertStatement.setInt(2, matriculas.getGradoID());
        insertStatement.setInt(3, matriculas.getHorario1());
        insertStatement.setInt(4, matriculas.getHorario2());
        insertStatement.setInt(5, matriculas.getHorario3());
        insertStatement.setInt(6, matriculas.getHorario4());
        insertStatement.setInt(7, matriculas.getHorario5());
        insertStatement.setInt(8, matriculas.getHorario6());
        insertStatement.setInt(9, matriculas.getHorario7());
        insertStatement.setInt(10, matriculas.getHorario8());
        insertStatement.setInt(11, matriculas.getHorario9());
        insertStatement.setInt(12, matriculas.getHorario10());
        insertStatement.setInt(13, matriculas.getHorario11());
        insertStatement.setInt(14, matriculas.getHorario12());
        insertStatement.setInt(15, matriculas.getHorario13());
        insertStatement.setInt(16, matriculas.getHorario14());
        insertStatement.setInt(17, matriculas.getHorario15());
        insertStatement.setInt(18, matriculas.getHorario16());
        insertStatement.setInt(19, matriculas.getHorario17());
        insertStatement.setInt(20, matriculas.getHorario18());
        insertStatement.setInt(21, matriculas.getHorario19());
        insertStatement.setInt(22, matriculas.getHorario20());
        insertStatement.setInt(23, matriculas.getHorario21());
        insertStatement.setInt(24, matriculas.getHorario22());
        insertStatement.setInt(25, matriculas.getHorario23());

        insertStatement.executeUpdate();
        insertStatement.close();

        // Actualización de cupos en grados
        updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setInt(1, gradoID);
        updateStatement.executeUpdate();
        updateStatement.close();

        // Confirmar la transacción
        connection.commit();
        System.out.println("Registro creado correctamente");
        return true;
    } catch (SQLException e) {
        // Deshacer la transacción en caso de error
        try {
            connection.rollback();
            System.out.println("Ocurrió un error. No se pudo crear el registro");
            
        } catch (SQLException rollbackException) {
            rollbackException.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        // Cerrar los recursos
        if (insertStatement != null) {
            insertStatement.close();
        }
        if (updateStatement != null) {
            updateStatement.close();
        }
    }
        return false;
}
    public boolean crearRegistroInicial(Connection connection, modelo_matriculas matriculas, int gradoID) throws SQLException {
    String insertQuery = "INSERT INTO matriculas (estudianteID,gradoID,horario1, horario2, horario3, horario4, horario5, horario6, horario7, horario8, horario9, horario10) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    String updateQuery = "UPDATE grados SET cupos = cupos - 1 WHERE gradoID = ?";
    
    PreparedStatement insertStatement = null;
    PreparedStatement updateStatement = null;

    try {
        // Iniciar la transacción
        connection.setAutoCommit(false);

        // Inserción en matriculas
        insertStatement = connection.prepareStatement(insertQuery);
        insertStatement.setString(1, matriculas.getEstudianteID());
        insertStatement.setInt(2, matriculas.getGradoID());
        insertStatement.setInt(3, matriculas.getHorario1());
        insertStatement.setInt(4, matriculas.getHorario2());
        insertStatement.setInt(5, matriculas.getHorario3());
        insertStatement.setInt(6, matriculas.getHorario4());
        insertStatement.setInt(7, matriculas.getHorario5());
        insertStatement.setInt(8, matriculas.getHorario6());
        insertStatement.setInt(9, matriculas.getHorario7());
        insertStatement.setInt(10, matriculas.getHorario8());
        insertStatement.setInt(11, matriculas.getHorario9());
        insertStatement.setInt(12, matriculas.getHorario10());


        insertStatement.executeUpdate();
        insertStatement.close();

        // Actualización de cupos en grados
        updateStatement = connection.prepareStatement(updateQuery);
        updateStatement.setInt(1, gradoID);
        updateStatement.executeUpdate();
        updateStatement.close();

        // Confirmar la transacción
        connection.commit();
        System.out.println("Registro creado correctamente");
        return true;
    } catch (SQLException e) {
        // Deshacer la transacción en caso de error
        try {
            connection.rollback();
            System.out.println("Ocurrió un error. No se pudo crear el registro");
            
        } catch (SQLException rollbackException) {
            rollbackException.printStackTrace();
        }
        e.printStackTrace();
    } finally {
        // Cerrar los recursos
        if (insertStatement != null) {
            insertStatement.close();
        }
        if (updateStatement != null) {
            updateStatement.close();
        }
    }
        return false;
}

    
    /*public void crearRegistro23(Connection connection,  modelo_matriculas matriculas) throws SQLException {
        String query = "INSERT INTO matriculas(estudianteID,gradoID,horario1, horario2, horario3, horario4, horario5, horario6, horario7, horario8, horario9, horario10, horario11, horario12, horario13, horario14, horario15, horario16, horario17, horario18, horario19, horario20, horario21, horario22, horario23) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(query);
        
        statement.setString(1, matriculas.getEstudianteID());
        statement.setInt(2, matriculas.getGradoID());
        statement.setInt(3, matriculas.getHorario1());
        statement.setInt(4, matriculas.getHorario2());
        statement.setInt(5, matriculas.getHorario3());
        statement.setInt(6, matriculas.getHorario4());
        statement.setInt(7, matriculas.getHorario5());
        statement.setInt(8, matriculas.getHorario6());
        statement.setInt(9, matriculas.getHorario7());
        statement.setInt(10, matriculas.getHorario8());
        statement.setInt(11, matriculas.getHorario9());
        statement.setInt(12, matriculas.getHorario10());
        statement.setInt(13, matriculas.getHorario11());
        statement.setInt(14, matriculas.getHorario12());
        statement.setInt(15, matriculas.getHorario13());
        statement.setInt(16, matriculas.getHorario14());
        statement.setInt(17, matriculas.getHorario15());
        statement.setInt(18, matriculas.getHorario16());
        statement.setInt(19, matriculas.getHorario17());
        statement.setInt(20, matriculas.getHorario18());
        statement.setInt(21, matriculas.getHorario19());
        statement.setInt(22, matriculas.getHorario20());
        statement.setInt(23, matriculas.getHorario21());
        statement.setInt(24, matriculas.getHorario22());
        statement.setInt(25, matriculas.getHorario23());


    
        int rowsInserted = statement.executeUpdate();
        JOptionPane.showMessageDialog(null,rowsInserted + " registro(s) creado(s)");
    }*/
    
    public ArrayList<Integer> buscarHorarios(Connection connection, int valor1) throws SQLException {
        String query = "SELECT horarioID FROM horarios WHERE gradoID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, valor1);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Integer> values= new ArrayList();
        while (resultSet.next()) {
            values.add(resultSet.getInt("horarioID"));
        }
        return values;
    }
    
    public ArrayList<modelo_matriculas> ListaMatriculas(Connection connection) throws SQLException {
    String query = "SELECT * FROM matriculas ";
    PreparedStatement statement = connection.prepareStatement(query);
    ResultSet resultSet = statement.executeQuery();
    ArrayList<modelo_matriculas> am = new ArrayList<>();

    while (resultSet.next()) {
        modelo_matriculas mm = new modelo_matriculas(); // Crear un nuevo objeto en cada iteración

        mm.setEstudianteID(resultSet.getString("estudianteID"));
        mm.setGradoID(resultSet.getInt("gradoID"));
        mm.setHorario1(resultSet.getInt("horario1"));
        mm.setHorario2(resultSet.getInt("horario2"));
        mm.setHorario3(resultSet.getInt("horario3"));
        mm.setHorario4(resultSet.getInt("horario4"));
        mm.setHorario5(resultSet.getInt("horario5"));
        mm.setHorario6(resultSet.getInt("horario6"));
        mm.setHorario7(resultSet.getInt("horario7"));
        mm.setHorario8(resultSet.getInt("horario8"));
        mm.setHorario9(resultSet.getInt("horario9"));
        mm.setHorario10(resultSet.getInt("horario10"));
        mm.setHorario11(resultSet.getInt("horario11"));
        mm.setHorario12(resultSet.getInt("horario12"));
        mm.setHorario13(resultSet.getInt("horario13"));
        mm.setHorario14(resultSet.getInt("horario14"));
        mm.setHorario15(resultSet.getInt("horario15"));
        mm.setHorario16(resultSet.getInt("horario16"));
        mm.setHorario17(resultSet.getInt("horario17"));
        mm.setHorario18(resultSet.getInt("horario18"));
        mm.setHorario19(resultSet.getInt("horario19"));
        mm.setHorario20(resultSet.getInt("horario20"));
        mm.setHorario21(resultSet.getInt("horario21"));
        mm.setHorario22(resultSet.getInt("horario22"));
        mm.setHorario23(resultSet.getInt("horario23"));
        mm.setHorario24(resultSet.getInt("horario24"));
        mm.setHorario25(resultSet.getInt("horario25"));

        am.add(mm);
    }
    return am;
}

    public modelo_matriculas buscarMatriculaInicial(Connection connection,int valor1) throws SQLException{
        String query = "SELECT estudianteID,gradoID,horario1,horario2,horario3,horario4,horario5 FROM horarios WHERE gradoID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, valor1);
        ResultSet resultSet = statement.executeQuery();
        modelo_matriculas mm= new modelo_matriculas();
        while (resultSet.next()) {
            mm.setEstudianteID(resultSet.getString("estudianteID"));
            mm.setGradoID(resultSet.getInt("gradoID"));
            mm.setHorario1(resultSet.getInt("horario1"));
            mm.setHorario2(resultSet.getInt("horario2"));
            mm.setHorario3(resultSet.getInt("horario3"));
            mm.setHorario4(resultSet.getInt("horario4"));
            mm.setHorario5(resultSet.getInt("horario5"));
        }
        return mm;
        
    }
    
     public boolean eliminarMatricula(Connection connection, String estudiante, String grado) throws SQLException {
        String deleteQuery = "DELETE FROM matriculas WHERE estudianteID=? and gradoID=?";
        String updateQuery = "UPDATE grados SET cupos=cupos+1 WHERE gradoID=?";

        try {
            connection.setAutoCommit(false); // Desactivar la confirmación automática de cambios

            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                 PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {

                deleteStatement.setString(1, estudiante);
                deleteStatement.setString(2, grado);

                updateStatement.setString(1, grado);

                int rowsDeleted = deleteStatement.executeUpdate();
                int rowsUpdated = updateStatement.executeUpdate();

                if (rowsDeleted > 0 && rowsUpdated > 0) {
                    connection.commit(); // Confirmar los cambios si ambas consultas se ejecutan correctamente
                    System.out.println("Eliminación de matrícula y actualización de cupos ejecutados correctamente.");
                    return true;
                } else {
                    connection.rollback(); // Revertir los cambios si alguna consulta no se ejecuta correctamente
                    System.out.println("No se pudieron eliminar la matrícula o actualizar los cupos.");
                    return false;
                }
            }
        } catch (SQLException e) {
            connection.rollback(); // Revertir los cambios en caso de excepción
            e.printStackTrace();
            return false;
        } finally {
            connection.setAutoCommit(true); // Restaurar la configuración de confirmación automática de cambios
        }
    }
     
    public modelo_matriculas buscarMatricula(Connection connection, String valor1) throws SQLException{
        String query="SELECT * FROM matriculas WHERE estudianteID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, valor1);
        ResultSet resultSet = statement.executeQuery();
        modelo_matriculas mm= new modelo_matriculas();
        while (resultSet.next()) {
            mm.setEstudianteID(resultSet.getString("estudianteID"));
            mm.setGradoID(resultSet.getInt("gradoID"));
            mm.setHorario1(resultSet.getInt("horario1"));
            mm.setHorario2(resultSet.getInt("horario2"));
            mm.setHorario3(resultSet.getInt("horario3"));
            mm.setHorario4(resultSet.getInt("horario4"));
            mm.setHorario5(resultSet.getInt("horario5"));
            mm.setHorario5(resultSet.getInt("horario5"));
            mm.setHorario6(resultSet.getInt("horario6"));
            mm.setHorario7(resultSet.getInt("horario7"));
            mm.setHorario8(resultSet.getInt("horario8"));
            mm.setHorario9(resultSet.getInt("horario9"));
            mm.setHorario10(resultSet.getInt("horario10"));
            mm.setHorario11(resultSet.getInt("horario11"));
            mm.setHorario12(resultSet.getInt("horario12"));
            mm.setHorario13(resultSet.getInt("horario13"));
            mm.setHorario14(resultSet.getInt("horario14"));
            mm.setHorario15(resultSet.getInt("horario15"));
            mm.setHorario16(resultSet.getInt("horario16"));
            mm.setHorario17(resultSet.getInt("horario17"));
            mm.setHorario18(resultSet.getInt("horario18"));
            mm.setHorario19(resultSet.getInt("horario19"));
            mm.setHorario20(resultSet.getInt("horario20"));
            mm.setHorario21(resultSet.getInt("horario21"));
            mm.setHorario22(resultSet.getInt("horario22"));
            mm.setHorario23(resultSet.getInt("horario23"));
            mm.setHorario24(resultSet.getInt("horario24"));
            mm.setHorario25(resultSet.getInt("horario25"));

        }
        return mm;
    }
    
    public ArrayList<Integer> Arrayhorarios(Connection connection, String valor1) throws SQLException {
        String query = "SELECT horario1, horario2, horario3, horario4, horario5, horario6, horario7, horario8, horario9, horario10, horario11, horario12, horario13, horario14, horario15, horario16, horario17, horario18, horario19, horario20, horario21, horario22, horario23, horario24, horario25 FROM matriculas WHERE estudianteID=?";
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setString(1, valor1);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<Integer> arrayhorarios = new ArrayList<>();

        while (resultSet.next()) {
            for (int i = 1; i <= 25; i++) {
                int horario = resultSet.getInt("horario" + i);
                if (resultSet.wasNull()) {
                    System.out.println("Se encontró un valor nulo en el horario " + i + ". El proceso se detendrá.");
                    return arrayhorarios;
                }
                arrayhorarios.add(horario);
            }
        }

        return arrayhorarios;
    }

    public ArrayList<modelo_estudiantes> buscarEstudiantesXGrado(Connection connection, int valor1) throws SQLException{
        String query="SELECT * FROM estudiantes WHERE estudiantes.estudianteID IN ( SELECT matriculas.estudianteID FROM matriculas WHERE matriculas.gradoID = ? )" ;
        PreparedStatement statement = connection.prepareStatement(query);
        statement.setInt(1, valor1);
        ResultSet resultSet = statement.executeQuery();
        ArrayList<modelo_estudiantes> ae= new ArrayList();
        while (resultSet.next()) {
            modelo_estudiantes me= new modelo_estudiantes();
            me.setEstudianteID(resultSet.getString("estudianteID"));
            me.setNombre(resultSet.getString("nombre"));
            me.setApellido(resultSet.getString("apellido"));
            me.setFechaNacimiento(resultSet.getString("fechaNacimiento"));
            me.setTelefono(resultSet.getString("telefono"));
            me.setCorreo(resultSet.getString("correo"));
            me.setNombreApoderado(resultSet.getString("nombreApoderado"));
            me.setApellidoApoderado(resultSet.getString("apellidoApoderado"));
            me.setTelefonoApoderado(resultSet.getString("telefonoApoderado"));
            me.setCorreoApoderado(resultSet.getString("correoApoderado"));
            me.setParentescoApoderado(resultSet.getString("parentescoApoderado"));
            ae.add(me);
        }
        return ae;
    }

}
