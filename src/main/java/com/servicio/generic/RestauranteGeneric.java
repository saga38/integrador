package com.servicio.generic;

import com.dto.Restaurante;

public interface RestauranteGeneric<Restaurante> extends GenericService<Restaurante> {
    String register(com.dto.Restaurante restaurantDto);

    void update(Object id, com.dto.Restaurante restaurantDto);

    // Aquí puedes agregar métodos específicos para el servicio de usuarios si los necesitas
}