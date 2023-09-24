/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_niveles {
    int nivelID;
    String nombreNivel;

    public modelo_niveles() {
    }

    public modelo_niveles(int nivelID, String nombreNivel) {
        this.nivelID = nivelID;
        this.nombreNivel = nombreNivel;
    }

    public int getNivelID() {
        return nivelID;
    }

    public void setNivelID(int nivelID) {
        this.nivelID = nivelID;
    }

    public String getNombreNivel() {
        return nombreNivel;
    }

    public void setNombreNivel(String nombreNivel) {
        this.nombreNivel = nombreNivel;
    }
    
}
