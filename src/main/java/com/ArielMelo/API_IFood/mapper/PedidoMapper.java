package com.ArielMelo.API_IFood.mapper;

import com.ArielMelo.API_IFood.dto.PedidoDTO;
import com.ArielMelo.API_IFood.entities.Entregador;
import com.ArielMelo.API_IFood.entities.Pedido;
import com.ArielMelo.API_IFood.entities.Produto;
import com.ArielMelo.API_IFood.entities.Restaurante;
import com.ArielMelo.API_IFood.enums.StatusPedido;

import java.util.List;

public class PedidoMapper {

    public static Pedido toEntity(PedidoDTO dto, Restaurante restaurante, Entregador entregador, List<Produto> produtos) {
        Pedido pedido = new Pedido();
        pedido.setEnderecoEntrega(dto.getEnderecoEntrega());
        pedido.setStatus(StatusPedido.valueOf(dto.getStatus()));
        pedido.setRestaurante(restaurante);
        pedido.setEntregador(entregador);
        pedido.setProdutos(produtos);
        return pedido;
    }

    public static PedidoDTO toDTO(Pedido pedido) {
        PedidoDTO dto = new PedidoDTO();
        dto.setId(pedido.getId());
        dto.setEnderecoEntrega(pedido.getEnderecoEntrega());
        dto.setStatus(pedido.getStatus().name());
        dto.setRestauranteId(pedido.getRestaurante().getId());
        dto.setEntregadorId(pedido.getEntregador().getId());
        dto.setProdutosIds(pedido.getProdutos().stream().map(Produto::getId).toList());
        return dto;
    }
}
