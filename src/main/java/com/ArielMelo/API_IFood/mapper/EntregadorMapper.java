package com.ArielMelo.API_IFood.mapper;

import com.ArielMelo.API_IFood.dto.EntregadorDTO;
import com.ArielMelo.API_IFood.entities.Entregador;

public class EntregadorMapper {

    public static Entregador toEntity(EntregadorDTO dto) {
        Entregador entregador = new Entregador();
        entregador.setNome(dto.getNome());
        entregador.setTelefone(dto.getTelefone());
        return entregador;
    }

    public static EntregadorDTO toDTO(Entregador entregador) {
        EntregadorDTO dto = new EntregadorDTO();
        dto.setId(entregador.getId());
        dto.setNome(entregador.getNome());
        dto.setTelefone(entregador.getTelefone());
        return dto;
    }
}
