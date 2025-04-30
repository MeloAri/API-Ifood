package com.ArielMelo.API_IFood.controller;

import com.ArielMelo.API_IFood.entities.Entregador;
import com.ArielMelo.API_IFood.repositories.EntregadorRepository;
import com.ArielMelo.API_IFood.service.EntregadorService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/entregadores")
@AllArgsConstructor
public class EntregadorController {

    private final EntregadorService entregadorService;

    @PostMapping
    public Entregador criar(@RequestBody Entregador entregador){
        return entregadorService.salvar(entregador);
    }

    @GetMapping
    public List<Entregador> listar(){
        return entregadorService.listarTodos();
    }

    @GetMapping("/{id}")
    public Entregador buscarPorId(@PathVariable Long id){
        return entregadorService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        entregadorService.deletar(id);
    }
}
