package com.ArielMelo.API_IFood.service;

import com.ArielMelo.API_IFood.dto.RestauranteDTO;
import com.ArielMelo.API_IFood.entities.Restaurante;
import com.ArielMelo.API_IFood.exceptions.RestauranteExpetion;
import com.ArielMelo.API_IFood.mapper.RestauranteMapper;
import com.ArielMelo.API_IFood.repositories.RestauranteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class RestauranteService {

    private final RestauranteRepository repository;

    public RestauranteDTO criarRestaurante(RestauranteDTO dto) {
        Restaurante restaurante = RestauranteMapper.toEntity(dto);
        Restaurante salvo = repository.save(restaurante);
        return RestauranteMapper.toDTO(salvo);
    }

    public Restaurante salvar(Restaurante restaurante){
        return repository.save(restaurante);
    }

    public List<Restaurante> listarTodos(){
        return repository.findAll();
    }

    public Restaurante buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new RestauranteExpetion("Restaurante não Encontrado"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
