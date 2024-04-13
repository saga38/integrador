package com.repositorios;

import com.database.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservacionRepository extends JpaRepository<Reservation, Object> {
}
