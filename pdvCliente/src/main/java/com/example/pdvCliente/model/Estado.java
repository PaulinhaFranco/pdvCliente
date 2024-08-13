package com.example.pdvCliente.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "ESTADO")

public class Estado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    // Relacionamento OneToMany com Cidade
    // mappedBy indica que a entidade Cidade é a proprietaria do relacionamento (tem a FK referente a Estado)
    // orphanRemoval = true - garante que se uma cidade for removida de Cidade, tbm sera removida do BD
    // Set<Cidade> garante que não haja duplicatas de cidades associadas a um Estado

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Cidade> cidades = new HashSet<>();

}
