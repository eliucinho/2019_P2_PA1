/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.pa1.controladores;

import hn.uth.pa1.pa1.objetos.Humano;
import java.util.List;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import jdk.nashorn.internal.runtime.ListAdapter;

/**
 *
 * @author Alumno
 */
public class controlodaroHumano {
    //almacen de información
    public static List<Humano> lista=new ArrayList<>();
    
    public static void inicializar(){
        lista.add(new Humano(1, "Maria"));
        lista.add(new Humano(2, "Jose"));
        lista.add(new Humano(3, "Manuel"));
        lista.add(new Humano(4, "Adan"));
        lista.add(new Humano(5, "Francis"));
        lista.add(new Humano(6, "Gerson"));
    }
    
    public static void actualizarHumano(Humano humano){
        Humano tmp=buscar(humano.getId());
        
        if (tmp!=null) {
            tmp.setId(humano.getId()); //Los id no se actualizan, se hace solo con fines academicos
            tmp.setNombre(humano.getNombre());
        }else{
            guardarHumano(humano);
        }
    }
    
    public static void guardarHumano(Humano humano){
        lista.add(humano);
    }
    
    public static Humano buscar(int id){
        for (Humano tmp : lista) {
            if (tmp.getId()==id) {
                return tmp;
            }
        }
        return null;
    }
    
    public static void eliminar(int id){
        lista.remove(buscar(id));
    }
    
    public static DefaultTableModel getDefaulModelHumano(){
        String[][] datos=new String[lista.size()][2];
        
        for (int i = 0; i < lista.size(); i++) {
            Humano tmp = lista.get(i);
            datos[i][0]=String.valueOf(tmp.getId());
            datos[i][1]=tmp.getNombre();
        }
        return new javax.swing.table.DefaultTableModel(
            /*new Object [][] {
                {"1", "Eliud"},
                {"2", "Adelman"},
                {"3", "Jose"},
                {"4", "Andres"}
            }*/
            datos,
            new String [] {
                "ID", "Nombre"
            }
        );
    }
}
