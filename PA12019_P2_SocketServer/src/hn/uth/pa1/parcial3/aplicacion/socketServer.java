/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial3.aplicacion;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 *
 * @author uth
 */
public class socketServer {
    Socket socket;
    ServerSocket serverSocket;
    DataInputStream dataInputStream = null;
    DataOutputStream dataOutputStream = null;
    
    public void crearConexion(){
        try {
            serverSocket=new ServerSocket(8484);
            socket=serverSocket.accept();
        } catch (Exception e) {
            System.out.println
            ("Error crearConexion: "+e.toString());
        }
    }
    
    public void cerrarConexion(){
        try {
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (Exception e) {
            System.out.println("Error cerrarConexion"+
                    e.toString());
        }
    }
    
    public void actualizarSolicitudesRespuestas(){
        try {
            dataInputStream=
                    new DataInputStream
                        (socket.getInputStream());
            dataOutputStream=
                    new DataOutputStream
                        (socket.getOutputStream());
            dataOutputStream.flush();
        } catch (Exception e) {
            System.out.println
            ("Erro actualizarSolicitudesRespuestas: "+e.toString());
        }
    }
    public void enviarSolicitudes
        (String mensaje){
        try {
            dataOutputStream.writeUTF(mensaje);
            dataOutputStream.flush();
        } catch (Exception e) {
            System.out.println
            ("Error enviarSolicitudes: "
            +e.toString()
            );
        }
    }
    public void leerSolicitudes(){
        String mensajeNuevo="";
        try {
            while (true) {                
                mensajeNuevo=dataInputStream.readUTF();
                System.out.println(mensajeNuevo);
            }
        } catch (Exception e) {
            System.out.println
            ("Error leerSolicitudes: "
            +e.toString()
            );
        }
    }
    
    public void ejecutarComunicacion(){
        Thread hilo=
                new Thread(
                        new Runnable(){
                            @Override
                            public void run(){
                                while (true) {                                    
                                    try {
                                        crearConexion();
                                        actualizarSolicitudesRespuestas();
                                        leerSolicitudes();
                                    } catch (Exception e) {
                                    }finally{
                                        cerrarConexion();
                                    }
                                }
                            }
                        }
                );
        hilo.start();
    }
    
    public static void main(String [] args){
        socketServer socketPrograma=new socketServer();
        Scanner scan=new Scanner(System.in);
        
        socketPrograma.ejecutarComunicacion();
        
        while (true) {            
            String mensaje=scan.nextLine();
            socketPrograma.enviarSolicitudes(mensaje);
        }
        
    }
}
