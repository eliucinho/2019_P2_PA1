/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.pa1.objetos;

/**
 *
 * @author Alumno
 */
public class Humano {
    private int id;
    private String nombre;

    public Humano(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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

    @Override
    public String toString() {
        return "Humano{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
}
