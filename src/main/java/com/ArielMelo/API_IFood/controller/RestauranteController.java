package com.ArielMelo.API_IFood.controller;

import com.ArielMelo.API_IFood.entities.Restaurante;
import com.ArielMelo.API_IFood.service.RestauranteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurante")
@AllArgsConstructor
public class RestauranteController {

    private final RestauranteService restauranteService;

    @PostMapping
    public Restaurante criar(@RequestBody Restaurante restaurante){
        return restauranteService.salvar(restaurante);
    }

    @GetMapping
    public List<Restaurante> listar(){
        return restauranteService.listarTodos();
    }

    @GetMapping("/{id}")
    public Restaurante buscarPorId(@PathVariable Long id){
        return restauranteService.buscarPorId(id);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id){
        restauranteService.deletar(id);
    }
}
