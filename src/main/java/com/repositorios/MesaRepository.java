package com.repositorios;

import com.database.Table_Restaurant;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MesaRepository extends JpaRepository<Table_Restaurant, Object> {
}
