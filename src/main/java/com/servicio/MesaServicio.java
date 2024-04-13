package com.servicio;

import com.database.Table_Restaurant;
import com.dto.Mesa;
import com.repositorios.MesaRepository;
import com.servicio.generic.MesaGeneric;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MesaServicio implements MesaGeneric<Mesa> {

    @Autowired
    private MesaRepository mesaRepository;

    @Override
    public String register(Mesa tableDto) {

        Table_Restaurant m = Table_Restaurant.builder()
                .estado(tableDto.getEstado())
                .capacidad(tableDto.getCapacidad())
                .restaurante(tableDto.getRestaurante())
                .build();

        mesaRepository.save(m);
        return "";
    }


    @Override
    public void update(Object id, Mesa tableDto) {
        Table_Restaurant table = mesaRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Table not found"));

        // Solo actualiza los campos que pueden cambiar
        table.setCapacidad(tableDto.getCapacidad());
        table.setEstado(tableDto.getEstado());

        mesaRepository.save(table);
    }

    @Override
    public List<Mesa> findAll() {
        List<Table_Restaurant> tables = mesaRepository.findAll();
        return convertToDtoList(tables);
    }

    @Override
    public void remove(Object id) {

        mesaRepository.deleteById(id);
    }

    private Mesa convertToDto(Table_Restaurant table) {
        Mesa tableDto = new Mesa();
        tableDto.setId(table.getId());
        tableDto.setRestaurante(table.getRestaurante().getId());
        tableDto.setCapacidad(table.getCapacidad());
        tableDto.setEstado(table.getEstado());

        return tableDto;
    }

    private List<Mesa> convertToDtoList(List<Table_Restaurant> tables) {
        return tables.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
    }

    @Override
    public Mesa findById(Object id) {
        Table_Restaurant table = mesaRepository.findById((Integer) id)
                .orElseThrow(() -> new IllegalArgumentException("Table not found"));
        return convertToDto(table);
    }
}
