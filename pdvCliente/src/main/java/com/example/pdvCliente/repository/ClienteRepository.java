package com.example.pdvCliente.repository;

import com.example.pdvCliente.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {
}
