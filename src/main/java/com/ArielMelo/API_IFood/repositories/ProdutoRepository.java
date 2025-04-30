package com.ArielMelo.API_IFood.repositories;

import com.ArielMelo.API_IFood.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
