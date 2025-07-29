/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.crudjava;
import java.sql.*;
/**
 *
 * @author artur
 */
public class Conexion {
    
    private static final String URL = "jdbc:mysql://localhost:3306/animalcenter";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "0000";

    public static Connection conectar() {
        try {
            Connection conn = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.out.println(" Conexión exitosa a la base de datos.");
            return conn;
        } catch (SQLException e) {
            System.out.println(" Error al conectar: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        conectar(); // solo para probar
    }
    
}
