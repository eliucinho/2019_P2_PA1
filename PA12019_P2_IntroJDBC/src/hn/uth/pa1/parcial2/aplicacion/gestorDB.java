/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hn.uth.pa1.parcial2.aplicacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author uth
 */
public class gestorDB {

    /**
     * Retorna una conexion a la base de datos derby local
     *
     * @return objeto conexion
     */
    public static Connection getConexion() {
        try {
            String usuario = "uth";
            String contrasenia = "uth";
            String url = "jdbc:derby://localhost:1527/uth";

            return DriverManager.getConnection(url, usuario, contrasenia);
        } catch (Exception e) {
            System.out.println("Error getConexion: " + e.toString());
        }
        return null;
    }

    public static void guardarHumano(
            int id,
            String nombre,
            String apellido,
            double peso,
            String sexo,
            String departamento,
            String municipio
    ) {
        try {
            //1.- Obtener la conexion
            Connection con = getConexion();

            //2.- SQL de insert
            String sql = "insert into uth.humanos "
                    + "(ID, NOMBRE, APELLIDO, PESO, SEXO, DEPARTAMENTO, MUNICIPIO)  "
                    + "values "
                    + "(?,?,?,?,?,?,?)";
            
            //3. Preparar el query
            PreparedStatement ps=con.prepareStatement(sql);
            
            //4. Asignar valores a los signos de interrogacion
            ps.setInt(1, id);
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setDouble(4, peso);
            ps.setString(5, sexo);
            ps.setString(6, departamento);
            ps.setString(7, municipio);
            
            //5. Ejecutar el query
            ps.execute();
            
            //6. Cerrar la conexion
            ps.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Error guardarHumano: "+e.toString());
        }
    }

}
