/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_horarios {
    int horarioID;
    String horaInicio;
    String horaFinal;
    int materiaID;
    String profesorID;
    int gradoID;
    int salonID;
    String dia;

    public modelo_horarios(String horaInicio, String horaFinal, int materiaID, String profesorID, int gradoID, int salonID, String dia) {
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.materiaID = materiaID;
        this.profesorID = profesorID;
        this.gradoID = gradoID;
        this.salonID = salonID;
        this.dia = dia;
    }

    
    public modelo_horarios(int horarioID, String horaInicio, String horaFinal, int materiaID, String profesorID, int gradoID, int salonID, String dia) {
        this.horarioID = horarioID;
        this.horaInicio = horaInicio;
        this.horaFinal = horaFinal;
        this.materiaID = materiaID;
        this.profesorID = profesorID;
        this.gradoID = gradoID;
        this.salonID = salonID;
        this.dia = dia;
    }

    public modelo_horarios() {
    }

    public int getHorarioID() {
        return horarioID;
    }

    public void setHorarioID(int horarioID) {
        this.horarioID = horarioID;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public String getHoraFinal() {
        return horaFinal;
    }

    public void setHoraFinal(String horaFinal) {
        this.horaFinal = horaFinal;
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

    public int getGradoID() {
        return gradoID;
    }

    public void setGradoID(int gradoID) {
        this.gradoID = gradoID;
    }

    public int getSalonID() {
        return salonID;
    }

    public void setSalonID(int salonID) {
        this.salonID = salonID;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }
    
    
    
}
