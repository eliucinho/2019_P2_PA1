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
public class programa {
    public static void main(String [] args){
        System.out.println("Hola mundo");
        
        Humanos nuevo=new Humanos();
        nuevo.setId(500);
        nuevo.setNombre("Jose");
        nuevo.setApellido("Reyes");
        nuevo.setDepartamento("FM");
        nuevo.setMunicipio("DC");
        nuevo.setPeso(100.00);
        nuevo.setSexo("M");
        
        gestorJPA.saveHumano(nuevo);
    }
}
