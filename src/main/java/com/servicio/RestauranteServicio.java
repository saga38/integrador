package com.servicio;

import com.database.Restaurant;
import com.dto.Restaurante;
import com.repositorios.RestaurantRepository;
import com.servicio.generic.RestauranteGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RestauranteServicio implements RestauranteGeneric<Restaurante> {

    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public String register(Restaurante restaurantDto) {
        Restaurant restaurant = new Restaurant();
        restaurant.setNombre(restaurantDto.getNombre());
        restaurant.setDireccion(restaurantDto.getDireccion());
        restaurant.setTelefono(restaurantDto.getTelefono());
        restaurant.setHorarioApertura(restaurantDto.getHoraapertura());
        restaurant.setHorarioCierre(restaurantDto.getHoracierre());

        restaurantRepository.save(restaurant);
        return "";
    }

    @Override
    public void update(Object id, Restaurante restaurantDto) {
        Restaurant restaurant = restaurantRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));

        // Actualiza los campos del restaurante
        restaurant.setNombre(restaurantDto.getNombre());
        restaurant.setDireccion(restaurantDto.getDireccion());
        restaurant.setTelefono(restaurantDto.getTelefono());
        restaurant.setHorarioApertura(restaurantDto.getHoraapertura());
        restaurant.setHorarioCierre(restaurantDto.getHoracierre());

        restaurantRepository.save(restaurant);
    }



    @Override
    public Restaurante findById(Object id) {


        Restaurant restaurant = restaurantRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Restaurant not found"));
        return convertToDto(restaurant);
    }

    @Override
    public List<Restaurante> findAll() {
        List<Restaurant> restaurants = restaurantRepository.findAll();
        return convertToDtoList(restaurants);
    }

    @Override
    public void remove(Object id) {
        restaurantRepository.deleteById((Integer) id);
    }

    private Restaurante convertToDto(Restaurant restaurant) {
        Restaurante restaurantDto = new Restaurante();
        restaurantDto.setId(restaurant.getId());
        restaurantDto.setNombre(restaurant.getNombre());
        restaurantDto.setDireccion(restaurant.getDireccion());
        restaurantDto.setTelefono(restaurant.getTelefono());
        restaurantDto.setHoraapertura(restaurant.getHorarioApertura());
        restaurantDto.setHoracierre(restaurant.getHorarioCierre());

        return restaurantDto;
    }

    private List<Restaurante> convertToDtoList(List<Restaurant> restaurants) {
        return restaurants.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }
}