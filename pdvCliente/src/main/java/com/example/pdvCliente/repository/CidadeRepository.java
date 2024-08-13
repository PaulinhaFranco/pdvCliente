package com.example.pdvCliente.repository;

import com.example.pdvCliente.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}
