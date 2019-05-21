/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial1.objetos;

/**
 *
 * @author eliucinho
 */
public class Persona {
    private int id;
    private String nombre;
    private String apellido;
    private double peso;

    public Persona(int id, String nombre, String apellido, double peso) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.peso = peso;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    @Override
    public String toString() {
        return "Persona{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", peso=" + peso + '}';
    }
    
}
