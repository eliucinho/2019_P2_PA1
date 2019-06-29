/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial2.aplicacion;

/**
 *
 * @author uth
 */
public class programa {
    public static void main(String [] args){
        System.out.println("HOla mundo");
        
        gestorDB.guardarHumano(2019, "Uth prueba"
                , " tegucigalpa ", 100, "M", "FM", "DC");
        
        
    }
}
