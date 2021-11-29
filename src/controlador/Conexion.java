/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
/**
 *
 * @author leoar
 * @version 28-11-2021
 */
public class Conexion {
    
    public Connection obtenerConexion(){
        Connection connection = null;
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","");
            System.out.println("Conexion exitosa");
        } catch (Exception e) {
            System.out.println("Error de conexion (Estoy en la clase conexion" + e.getMessage());
        }
        return connection;
    }
    
//    public static void main(String[] args) {
//        Conexion con = new Conexion ();
//        con.obtenerConexion();
//    }
    
}
