package com.ArielMelo.API_IFood.service;

import com.ArielMelo.API_IFood.entities.Entregador;
import com.ArielMelo.API_IFood.exceptions.EntregadoException;
import com.ArielMelo.API_IFood.repositories.EntregadorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class EntregadorService {

    private final EntregadorRepository repository;

    public Entregador salvar(Entregador entregador){
        return repository.save(entregador);
    }

    public List<Entregador> listarTodos(){
        return repository.findAll();
    }

    public Entregador buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new EntregadoException("Entregador não encontrado"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
