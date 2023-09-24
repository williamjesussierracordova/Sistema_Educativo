/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_salones {
    int salonID;
    String nombreSalon;

    public modelo_salones() {
    }

    public modelo_salones(int salonID, String nombreSalon) {
        this.salonID = salonID;
        this.nombreSalon = nombreSalon;
    }

    public int getSalonID() {
        return salonID;
    }

    public void setSalonID(int salonID) {
        this.salonID = salonID;
    }

    public String getNombreSalon() {
        return nombreSalon;
    }

    public void setNombreSalon(String nombreSalon) {
        this.nombreSalon = nombreSalon;
    }
    
    
}
