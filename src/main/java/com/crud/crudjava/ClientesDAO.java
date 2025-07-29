/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.crudjava;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author artur
 */
public class ClientesDAO {
     public void crearClientes(Clientes c){
        String sql = "INSERT INTO cliente (id_cliente,nombre, ciudad, direccion, telefono) VALUES (?,?,?,?,?)";

    try(Connection conn = Conexion.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setLong(1,c.getIdCliente());
        stmt.setString(2,c.getNombre());
        stmt.setString(3,c.getCiudad());
        stmt.setString(4,c.getDireccion());
        stmt.setString(5,c.getTelefono());

        stmt.executeUpdate();
    }
     catch (SQLException e) {
        System.out.println(" Error al registrar cliente: " + e.getMessage());
    }
   }

   public List<Clientes> listarClientes(){
        List<Clientes> lista = new ArrayList<>();
        String sql = "SELECT * FROM cliente";

        try(Connection conn = Conexion.conectar();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()){
                Clientes Clientes = new Clientes(
                        rs.getLong("id_cliente"),
                        rs.getString("nombre"),
                        rs.getString("ciudad"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                );
                lista.add(Clientes);
            }
        }catch (SQLException e) {
            System.out.println(" Error al cargar la lista de clientes: " + e.getMessage());
   }
        return lista;
}

public Clientes buscarPorId(int id) {
    Clientes clientes = null;
    String sql =  "SELECT * FROM cliente WHERE id_cliente = ?";

    try(Connection conn = Conexion.conectar();
        PreparedStatement stmt = conn.prepareStatement(sql)){

        stmt.setInt(1,id);
        ResultSet rs = stmt.executeQuery();

        if (rs.next()){
            clientes = new Clientes(
                    rs.getLong("id_cliente"),
                    rs.getString("nombre"),
                    rs.getString("ciudad"),
                    rs.getString("direccion"),
                    rs.getString("telefono")
            );
        }
    } catch (SQLException e) {
        System.out.println("❌ Error al buscar el cliente: " + e.getMessage());

    }

        return clientes;
    }

    public void actualizarClientes(Clientes c){
        String sql = "UPDATE cliente SET id_cliente=?, nombre=?, ciudad=?, direccion=?, telefono=? WHERE id_cliente=?";

        try(Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1,c.getIdCliente());
            stmt.setString(2,c.getNombre());
            stmt.setString(3,c.getCiudad());
            stmt.setString(4,c.getDireccion());
            stmt.setString(5,c.getTelefono());
            stmt.setLong(6, c.getIdCliente());

            stmt.executeUpdate();

        } catch(SQLException e) {
            System.out.println(" Error al actualizar cliente: " + e.getMessage());

        }
    }

    public void eliminarCliente(Long id_cliente) {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";

        try(Connection conn = Conexion.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)){

            stmt.setLong(1,id_cliente);
            int filas = stmt.executeUpdate();

            if (filas > 0) {
                System.out.println(" Cliente eliminado correctamente.");
            } else {
                System.out.println("️ No se encontró cliente con ese ID.");
            }


        }catch(SQLException e) {
            System.out.println(" Error al eliminar cliente: " + e.getMessage());

        }
    }
}
