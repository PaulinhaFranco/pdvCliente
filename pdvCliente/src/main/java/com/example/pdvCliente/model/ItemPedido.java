package com.example.pdvCliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ITEMPEDIDO")

public class ItemPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "DESCONTO", length = 50, nullable = false)
    private Double desconto;

    @Column(name = "QUANTIDADE", length = 50, nullable = false)
    private Integer quantidade;

    @Column(name = "PRECO", length = 50, nullable = false)
    private Double preco;

}
