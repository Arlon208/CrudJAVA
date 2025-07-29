/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crud.crudjava;

/**
 *
 * @author artur
 */
public class Clientes {
    private Long idCliente;
    private String nombre;
    private String ciudad;
    private String direccion;
    private String telefono;


    public Clientes(Long idCliente, String nombre, String ciudad, String direccion, String telefono) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Long getIdCliente(){
        return idCliente;
    }

    public void setIdCliente(Long idCliente){
        this.idCliente = idCliente;
    }

    public String getNombre(){
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public String getCiudad(){
        return ciudad;
    }

    public void setCiudad(String ciudad){
        this.ciudad = ciudad;
    }

    public String getDireccion(){
        return direccion;
    }

    public void setDireccion(String direccion){
        this.direccion = direccion;
    }

    public String getTelefono(){
        return telefono;
    }

    public void setTelefono(String telefono){
        this.telefono = telefono;
    }
}
