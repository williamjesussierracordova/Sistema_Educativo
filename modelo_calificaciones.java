/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_calificaciones {
    String estudianteID;
    int materiaID;
    String profesorID;
    String descripcionEvaluacion;
    int calificacion;

    public modelo_calificaciones() {
    }

    public modelo_calificaciones(String estudianteID, int materiaID, String profesorID, String descripcionEvaluacion, int calificacion) {
        this.estudianteID = estudianteID;
        this.materiaID = materiaID;
        this.profesorID = profesorID;
        this.descripcionEvaluacion = descripcionEvaluacion;
        this.calificacion = calificacion;
    }

    public String getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(String estudianteID) {
        this.estudianteID = estudianteID;
    }

    public int getMateriaID() {
        return materiaID;
    }

    public void setMateriaID(int materiaID) {
        this.materiaID = materiaID;
    }

    public String getProfesorID() {
        return profesorID;
    }

    public void setProfesorID(String profesorID) {
        this.profesorID = profesorID;
    }

    public String getDescripcionEvaluacion() {
        return descripcionEvaluacion;
    }

    public void setDescripcionEvaluacion(String descripcionEvaluacion) {
        this.descripcionEvaluacion = descripcionEvaluacion;
    }

    public int getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int calificacion) {
        this.calificacion = calificacion;
    }    
    
}
