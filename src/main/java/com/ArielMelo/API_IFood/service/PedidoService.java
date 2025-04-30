package com.ArielMelo.API_IFood.service;

import com.ArielMelo.API_IFood.dto.PedidoDTO;
import com.ArielMelo.API_IFood.entities.Entregador;
import com.ArielMelo.API_IFood.entities.Pedido;
import com.ArielMelo.API_IFood.entities.Produto;
import com.ArielMelo.API_IFood.entities.Restaurante;
import com.ArielMelo.API_IFood.enums.StatusPedido;
import com.ArielMelo.API_IFood.mapper.PedidoMapper;
import com.ArielMelo.API_IFood.repositories.EntregadorRepository;
import com.ArielMelo.API_IFood.repositories.PedidoRepository;
import com.ArielMelo.API_IFood.repositories.ProdutoRepository;
import com.ArielMelo.API_IFood.repositories.RestauranteRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PedidoService {

    private final PedidoRepository pedidoRepository;
    private final RestauranteRepository restauranteRepository;
    private final EntregadorRepository entregadorRepository;
    private final ProdutoRepository produtoRepository;

    public PedidoDTO criarPedido(PedidoDTO dto) {
        Restaurante restaurante = restauranteRepository.findById(dto.getRestauranteId())
                .orElseThrow(() -> new RuntimeException("Restaurante não encontrado"));

        Entregador entregador = entregadorRepository.findById(dto.getEntregadorId())
                .orElseThrow(() -> new RuntimeException("Entregador não encontrado"));

        List<Produto> produtos = produtoRepository.findAllById(dto.getProdutosIds());

        Pedido pedido = PedidoMapper.toEntity(dto, restaurante, entregador, produtos);
        Pedido salvo = pedidoRepository.save(pedido);

        return PedidoMapper.toDTO(salvo);
    }

    public List<PedidoDTO> listarTodos() {
        return pedidoRepository.findAll().stream()
                .map(PedidoMapper::toDTO)
                .toList();
    }

    public PedidoDTO atualizarStatus(Long id, StatusPedido novoStatus) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado"));
        pedido.setStatus(novoStatus);
        return PedidoMapper.toDTO(pedidoRepository.save(pedido));
    }
}
