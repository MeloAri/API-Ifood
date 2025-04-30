package com.ArielMelo.API_IFood.repositories;

import com.ArielMelo.API_IFood.entities.Entregador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntregadorRepository extends JpaRepository<Entregador, Long> {
}
