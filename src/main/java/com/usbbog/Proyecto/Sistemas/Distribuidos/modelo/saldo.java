package com.usbbog.Proyecto.Sistemas.Distribuidos.modelo;

import javax.persistence.*;

@Entity
@Table(name = "saldo")
public class saldo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Integer idsaldo;
    private int usuario;
    private float dinero;

    public saldo() {
    }

    public saldo(Integer idsaldo, int usuario, float dinero) {
        this.idsaldo = idsaldo;
        this.usuario = usuario;
        this.dinero = dinero;
    }

    public Integer getIdsaldo() {
        return idsaldo;
    }

    public void setIdsaldo(Integer idsaldo) {
        this.idsaldo = idsaldo;
    }

    public int getUsuario() {
        return usuario;
    }

    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    public float getDinero() {
        return dinero;
    }

    public void setDinero(float dinero) {
        this.dinero = dinero;
    }

    @Override
    public String toString() {
        return "saldo{" +
                "idsaldo=" + idsaldo +
                ", usuario=" + usuario +
                ", dinero=" + dinero +
                '}';
    }
}
