package com.dto;

import com.database.Restaurant;
import com.database.Table_Restaurant;
import com.database.User;

import java.time.LocalDateTime;

public class Reservacion {
    private int id;
    private Object restaurante;
    private Object mesa;
    private Object user;
    private LocalDateTime fechardereservacion;
    private String estado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public void setRestaurante(Object restaurante) {
        this.restaurante = restaurante;
    }


    public void setUser(Object user) {
        this.user = user;
    }

    public LocalDateTime getFechardereservacion() {
        return fechardereservacion;
    }

    public void setFechardereservacion(LocalDateTime fechardereservacion) {
        this.fechardereservacion = fechardereservacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Table_Restaurant getMesa() {
        return (Table_Restaurant) this.mesa;
    }

    public void setMesa(Table_Restaurant mesa) {
        this.mesa = mesa;
    }

    public Restaurant getRestaurante() {
        return (Restaurant) this.restaurante;
    }

    public User getUser() {
        return (User) this.user;
    }
}
