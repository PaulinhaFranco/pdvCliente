package com.example.pdvCliente.repository;

import com.example.pdvCliente.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PedidoRepository extends JpaRepository<Pedido, Integer> {
}
