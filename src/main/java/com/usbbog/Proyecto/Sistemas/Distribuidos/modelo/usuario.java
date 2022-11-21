package com.usbbog.Proyecto.Sistemas.Distribuidos.modelo;

import javax.persistence.*;

@Entity
@Table(name = "usuario")
public class usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int idusuario;
    private String nombre;
    private String apellido;
    private String username;
    private String clave;

    public usuario() {
    }

    public usuario(int idusuario, String nombre, String apellido, String username, String clave) {
        this.idusuario = idusuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.username = username;
        this.clave = clave;
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "usuario{" +
                "idusuario=" + idusuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", username='" + username + '\'' +
                ", clave='" + clave + '\'' +
                '}';
    }
}
