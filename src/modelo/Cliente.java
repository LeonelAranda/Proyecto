/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author lucia
 */
public class Cliente {
    private int idcliente;
    private String run;
    private String nombre;
    private int telefono;
    private String direccion;

    public Cliente() {
    }

    public Cliente(int idcliente, String run, String nombre, int telefono, String direccion) {
        this.idcliente = idcliente;
        this.run = run;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
    }

    public int getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(int idcliente) {
        this.idcliente = idcliente;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        this.run = run;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    
    
}
