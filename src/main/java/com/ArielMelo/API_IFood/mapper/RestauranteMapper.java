package com.ArielMelo.API_IFood.mapper;

import com.ArielMelo.API_IFood.dto.RestauranteDTO;
import com.ArielMelo.API_IFood.entities.Restaurante;

public class RestauranteMapper {

    public static Restaurante toEntity(RestauranteDTO dto) {
        Restaurante restaurante = new Restaurante();
        restaurante.setNome(dto.getNome());
        restaurante.setEndereco(dto.getEndereco());
        return restaurante;
    }

    public static RestauranteDTO toDTO(Restaurante restaurante) {
        RestauranteDTO dto = new RestauranteDTO();
        dto.setId(restaurante.getId());
        dto.setNome(restaurante.getNome());
        dto.setEndereco(restaurante.getEndereco());
        return dto;
    }
}
