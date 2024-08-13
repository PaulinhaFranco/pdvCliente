package com.example.pdvCliente.repository;

import com.example.pdvCliente.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Integer> {
}
