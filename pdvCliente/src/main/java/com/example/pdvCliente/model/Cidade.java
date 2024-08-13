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
@Table(name = "CIDADE")

public class Cidade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    // Relacionamento ManyToOne com Estado
    @ManyToOne
    @JoinColumn(name = "ESTADO_ID", nullable = false)
    private Estado estado;
}
