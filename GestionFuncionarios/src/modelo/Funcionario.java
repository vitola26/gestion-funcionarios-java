/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

public class Funcionario {
    private int id;
    private String cedula;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private String fechaIngreso;

    // Constructor vacío
    public Funcionario() {}

    // Constructor con todos los campos
    public Funcionario(int id, String cedula, String nombre, String apellido,
                       String email, String telefono, String fechaIngreso) {
        this.id = id;
        this.cedula = cedula;
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getApellido() { return apellido; }
    public void setApellido(String apellido) { this.apellido = apellido; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getFechaIngreso() { return fechaIngreso; }
    public void setFechaIngreso(String f) { this.fechaIngreso = f; }

    // Para que el nombre aparezca bonito en listas
    @Override
    public String toString() {
        return nombre + " " + apellido;
    }
}


