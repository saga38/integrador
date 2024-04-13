package com.servicio;

import com.database.Reservation;
import com.database.Restaurant;
import com.database.Table_Restaurant;
import com.database.User;
import com.dto.Reservacion;
import com.repositorios.ReservacionRepository;
import com.servicio.generic.ReservacionGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservacionServicio implements ReservacionGeneric<Reservacion> {

    @Autowired
    private ReservacionRepository reservacionRepository;

    @Override
    public String register(Reservacion reservacion) {
        Reservation reservation = new Reservation();
        reservation.setRestaurante(reservacion.getRestaurante());
        reservation.setMesa(   reservacion.getMesa());
        reservation.setUsuario(reservacion.getUser());
        reservation.setFechadereservacion(reservacion.getFechardereservacion());
        reservation.setEstado(reservacion.getEstado());

        reservacionRepository.save(reservation);
        return "ok";
    }

    @Override
    public void update(Object id, Reservacion reservacion) {
        Reservation r = reservacionRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));

        // Solo actualiza los campos que pueden cambiar
        r.setMesa( reservacion.getMesa());
        r.setUsuario( reservacion.getUser());
        r.setFechadereservacion(reservacion.getFechardereservacion());
        r.setEstado(reservacion.getEstado());

        reservacionRepository.save(r);
    }

    @Override
    public Reservacion findById(Object id) {
        Reservation reservation = reservacionRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Booking not found"));
        return convertToDto(reservation);
    }

    @Override
    public List<Reservacion> findAll() {
        List<Reservation> reservations = reservacionRepository.findAll();
        return convertToDtoList(reservations);
    }

    @Override
    public void remove(Object id) {
        reservacionRepository.deleteById((Integer) id);
    }

    private Reservacion convertToDto(Reservation reservation) {
        Reservacion reservacion = new Reservacion();
        reservacion.setId(reservacion.getId());
        reservacion.setRestaurante(((Restaurant)reservacion.getRestaurante()).getId());
        reservacion.setMesa(  (Table_Restaurant)reservacion.getMesa());
        reservacion.setUser(((User) reservacion.getUser()).getId());
        reservacion.setFechardereservacion(reservacion.getFechardereservacion());
        reservacion.setEstado(reservacion.getEstado());

        return reservacion;
    }

    private List<Reservacion> convertToDtoList(List<Reservation> reservations) {
        return reservations.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}