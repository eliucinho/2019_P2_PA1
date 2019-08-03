/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcil3.aplicacion.db;

import hn.uth.pa1.parcil3.aplicacion.entidades.Humanos;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author uth
 */
public class gestorJPA {
    private static EntityManager em;
    
    private static void mensajeError
        (String nombreFuncion,
         String mensaje
    ){
        System.out.println("Error "+
                nombreFuncion+
                ": "+
                mensaje);
    }
    
    public static EntityManager getEm(){
        try {
            String unidad="humanosPU";
            EntityManagerFactory ef
                    =Persistence
                            .createEntityManagerFactory
                            (unidad);
            EntityManager entityManager=ef.createEntityManager();
            
            return entityManager;
        } catch (Exception e) {
            mensajeError("getEm", e.toString());
        }
        return null;
    }
    
    //Es un ejemplo de como se hace un insert
    public static void 
        saveHumano(Humanos humano){
       em=getEm();
       
       em.getTransaction().begin();
       em.persist(humano);
       em.getTransaction().commit();
       
       em.close();
    }
    public static Humanos 
        getHumano(int id){
       return em.find(Humanos.class, id);
    }
    public static void 
        iniciarTransaccion(){
       em=getEm();
       em.getTransaction().begin();
    }    
        
    public static void guardarCambiosTransaccion
        (){em.getTransaction().commit();
    }  
    public static void 
        guardarHumanos(Humanos humano){
       em.persist(humano);
    }     
    public static void eliminarHumano
        (Humanos humano){
        em.remove(humano);
    }
}


