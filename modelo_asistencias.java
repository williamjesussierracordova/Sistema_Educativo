/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_asistencias {
    String estudianteID;
    String fecha;
    String asistencia;

    public modelo_asistencias(String estudianteID, String fecha, String asistencia) {
        this.estudianteID = estudianteID;
        this.fecha = fecha;
        this.asistencia = asistencia;
    }

    public modelo_asistencias() {
    }

    public String getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(String estudianteID) {
        this.estudianteID = estudianteID;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(String asistencia) {
        this.asistencia = asistencia;
    }
    
    
}
