/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial3.aplicacion;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComponent;

/**
 *
 * @author uth
 */
public class ComponenteHilo extends Thread {
    JComponent componente;
    public ComponenteHilo(String name,
            JComponent componente){
        super(name);
        this.componente=componente;
    }
    @Override
    public void run(){
        while (componente.getLocation().x<300) {            
            cambiarX(10);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComponenteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while (componente.getLocation().x>-300) {            
            cambiarX(-10);
            try {
                sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(ComponenteHilo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void cambiarX(
            int grado
    ) {
        int x = componente.getLocation().x + grado;
        int y = componente.getLocation().y;
        componente.setLocation(x, y);
        
        System.out.println("x "+x);
    }
}
