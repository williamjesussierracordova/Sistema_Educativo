/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelos;

/**
 *
 * @author WILLIAM
 */
public class modelo_estudiantes {
    String estudianteID;
    String nombre;
    String apellido;
    String fechaNacimiento;
    String direccion;
    String telefono;
    String nombreApoderado;
    String apellidoApoderado;
    String parentescoApoderado;
    String telefonoApoderado;
    String direccionApoderado;
    String fechaInscripcion;
    String estadoEstudiante;
    String correo;
    String sexo;
    String correoApoderado;
    String fechaActualizacion;

    public modelo_estudiantes(String estudianteID, String nombre, String apellido, String fechaNacimiento, String direccion, String telefono, String nombreApoderado, String apellidoApoderado, String parentescoApoderado, String telefonoApoderado, String direccionApoderado, String fechaInscripcion) {
        this.estudianteID = estudianteID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreApoderado = nombreApoderado;
        this.apellidoApoderado = apellidoApoderado;
        this.parentescoApoderado = parentescoApoderado;
        this.telefonoApoderado = telefonoApoderado;
        this.direccionApoderado = direccionApoderado;
        this.fechaInscripcion = fechaInscripcion;
    }

    public modelo_estudiantes(String estudianteID, String nombre, String apellido, String fechaNacimiento, String direccion, String telefono, String nombreApoderado, String apellidoApoderado, String parentescoApoderado, String telefonoApoderado, String direccionApoderado, String fechaInscripcion, String estadoEstudiante, String correo, String sexo, String correoApoderado) {
        this.estudianteID = estudianteID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreApoderado = nombreApoderado;
        this.apellidoApoderado = apellidoApoderado;
        this.parentescoApoderado = parentescoApoderado;
        this.telefonoApoderado = telefonoApoderado;
        this.direccionApoderado = direccionApoderado;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoEstudiante = estadoEstudiante;
        this.correo = correo;
        this.sexo = sexo;
        this.correoApoderado = correoApoderado;
    }

    public modelo_estudiantes(String estudianteID, String nombre, String apellido, String fechaNacimiento, String direccion, String telefono, String nombreApoderado, String apellidoApoderado, String parentescoApoderado, String telefonoApoderado, String direccionApoderado, String fechaInscripcion, String estadoEstudiante, String correo, String sexo, String correoApoderado, String fechaActualizacion) {
        this.estudianteID = estudianteID;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.direccion = direccion;
        this.telefono = telefono;
        this.nombreApoderado = nombreApoderado;
        this.apellidoApoderado = apellidoApoderado;
        this.parentescoApoderado = parentescoApoderado;
        this.telefonoApoderado = telefonoApoderado;
        this.direccionApoderado = direccionApoderado;
        this.fechaInscripcion = fechaInscripcion;
        this.estadoEstudiante = estadoEstudiante;
        this.correo = correo;
        this.sexo = sexo;
        this.correoApoderado = correoApoderado;
        this.fechaActualizacion = fechaActualizacion;
    }
    
    
    public modelo_estudiantes() {
    }

    public String getFechaActualizacion() {
        return fechaActualizacion;
    }

    public void setFechaActualizacion(String fechaActualizacion) {
        this.fechaActualizacion = fechaActualizacion;
    }

    public String getEstudianteID() {
        return estudianteID;
    }

    public void setEstudianteID(String estudianteID) {
        this.estudianteID = estudianteID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getNombreApoderado() {
        return nombreApoderado;
    }

    public String getEstadoEstudiante() {
        return estadoEstudiante;
    }

    public void setEstadoEstudiante(String estadoEstudiante) {
        this.estadoEstudiante = estadoEstudiante;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCorreoApoderado() {
        return correoApoderado;
    }

    public void setCorreoApoderado(String correoApoderado) {
        this.correoApoderado = correoApoderado;
    }

    public void setNombreApoderado(String nombreApoderado) {
        this.nombreApoderado = nombreApoderado;
    }

    public String getApellidoApoderado() {
        return apellidoApoderado;
    }

    public void setApellidoApoderado(String apellidoApoderado) {
        this.apellidoApoderado = apellidoApoderado;
    }

    public String getParentescoApoderado() {
        return parentescoApoderado;
    }

    public void setParentescoApoderado(String parentescoApoderado) {
        this.parentescoApoderado = parentescoApoderado;
    }

    public String getTelefonoApoderado() {
        return telefonoApoderado;
    }

    public void setTelefonoApoderado(String telefonoApoderado) {
        this.telefonoApoderado = telefonoApoderado;
    }

    public String getDireccionApoderado() {
        return direccionApoderado;
    }

    public void setDireccionApoderado(String direccionApoderado) {
        this.direccionApoderado = direccionApoderado;
    }

    public String getFechaInscripcion() {
        return fechaInscripcion;
    }

    public void setFechaInscripcion(String fechaInscripcion) {
        this.fechaInscripcion = fechaInscripcion;
    }
    
    
}
