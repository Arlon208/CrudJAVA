/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.crud.crudjava;

/**
 *
 * @author artur
 */
public class CrudJava {

   public static void main(String[] args) {
        ClientesDAO dao = new ClientesDAO();

        // Insertar un nuevo cliente
        Clientes nuevo = new Clientes(11162656638L, "Arturo Londono", "Riofrio", "Calle 8c", "3167222922");
        Clientes nuevo1 = new Clientes(1116269977L, "Adriana Rios", "Tulua", "Calle 5a", "555877465");
        dao.crearClientes(nuevo);
        dao.crearClientes(nuevo1);


        // Listar Clientes
        for (Clientes c : dao.listarClientes()) {
            System.out.println(c.getIdCliente() + " - " + c.getNombre() + " - " + c.getDireccion() + " - " + c.getTelefono());
        }

        // Buscar por ID
        Clientes buscar = dao.buscarPorId(1116269977);
        if (buscar != null) {
            System.out.println("Encontrado: " + buscar.getNombre());
        }
         //Modificar Cliente
        buscar.setDireccion("Cartagena");
        dao.actualizarClientes(buscar);

        // Eliminar
        dao.eliminarCliente(11162656638L); // elimina al cliente con Cedula (Id) = 1116265639
    }
}
