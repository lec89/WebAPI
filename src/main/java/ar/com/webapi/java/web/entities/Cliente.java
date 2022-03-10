package ar.com.webapi.java.web.entities;

import ar.com.webapi.java.web.enums.TipoCliente;

public class Cliente {
    int id;
    String nombre;
    String apellido;
    TipoCliente tipoCliente;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, TipoCliente tipoCliente) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = tipoCliente;
    }

    public Cliente(int id, String nombre, String apellido, TipoCliente tipoCliente) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipoCliente = tipoCliente;
    }

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", tipoCliente=" + tipoCliente + '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
}