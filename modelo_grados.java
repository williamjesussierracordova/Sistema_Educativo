/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_grados {
    int gradoID;
    int grado;
    int nivelID;
    String seccion;
    String tutorID;
    int cupos;
    
    public modelo_grados() {
    }

    public modelo_grados(int gradoID, int grado, int nivelID, String seccion, String tutorID) {
        this.gradoID = gradoID;
        this.grado = grado;
        this.nivelID = nivelID;
        this.seccion = seccion;
        this.tutorID = tutorID;
    }

    public modelo_grados(int gradoID, int grado, int nivelID, String seccion, String tutorID, int cupos) {
        this.gradoID = gradoID;
        this.grado = grado;
        this.nivelID = nivelID;
        this.seccion = seccion;
        this.tutorID = tutorID;
        this.cupos = cupos;
    }

    public int getCupos() {
        return cupos;
    }

    public void setCupos(int cupos) {
        this.cupos = cupos;
    }

    public int getGradoID() {
        return gradoID;
    }

    public void setGradoID(int gradoID) {
        this.gradoID = gradoID;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public int getNivelID() {
        return nivelID;
    }

    public void setNivelID(int nivelID) {
        this.nivelID = nivelID;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getTutorID() {
        return tutorID;
    }

    public void setTutorID(String tutorID) {
        this.tutorID = tutorID;
    }
    
    
}
