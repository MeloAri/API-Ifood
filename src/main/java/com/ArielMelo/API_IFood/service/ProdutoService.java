package com.ArielMelo.API_IFood.service;

import com.ArielMelo.API_IFood.entities.Produto;
import com.ArielMelo.API_IFood.exceptions.ProdutoExpetion;
import com.ArielMelo.API_IFood.repositories.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {

    private final ProdutoRepository repository;

    public Produto salvar(Produto produto){
        return repository.save(produto);
    }

    public List<Produto> listarTodos(){
        return repository.findAll();
    }

    public Produto buscarPorId(Long id){
        return repository.findById(id).orElseThrow(() -> new ProdutoExpetion("Produto não encontrado"));
    }

    public void deletar(Long id){
        repository.deleteById(id);
    }
}
