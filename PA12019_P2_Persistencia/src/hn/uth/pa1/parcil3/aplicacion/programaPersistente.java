/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcil3.aplicacion;

import hn.uth.pa1.parcil3.aplicacion.db.gestorJPA;
import hn.uth.pa1.parcil3.aplicacion.entidades.Humanos;

/**
 *
 * @author uth
 */
public class programaPersistente {
    public static void main(String [] args){
        gestorJPA.iniciarTransaccion();
        
        Humanos nuevo=new Humanos();
        nuevo.setId(504);
        nuevo.setNombre("Jose");
        nuevo.setApellido("Reyes");
        nuevo.setDepartamento("FM");
        nuevo.setMunicipio("DC");
        nuevo.setPeso(100.00);
        nuevo.setSexo("M");
        
        gestorJPA.guardarHumanos(nuevo);
        System.out.println("MOdificando");
        Humanos modificado
                =gestorJPA.getHumano(500);
        modificado.setNombre("daniel");
        modificado.setApellido("ramos");
        
        System.out.println("Eliminando el 66");
        gestorJPA.eliminarHumano
                (gestorJPA.getHumano(66));
        
        gestorJPA.guardarCambiosTransaccion();
    }
}
