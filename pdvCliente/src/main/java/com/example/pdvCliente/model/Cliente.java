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
@Table(name = "CLIENTE")

public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "EMAIL", length = 100, nullable = false)
    private String email;

    @Column(name = "CPF_CPNJ", length = 14, nullable = false)
    private String cpf_cnpj;

    @Enumerated(EnumType.STRING)
    @Column(name = "TIPOCLIENTE", nullable = false)
    private TipoCliente tipoCliente;

    // Relacionamento OneToMany com Endereco
    // set para armazenar vários enderecos
    // cascade garante que as operações feitas em cliente sejam repassadas para os enderecos associados

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private Set<Endereco> enderecos = new HashSet<>();

    // Relacionamento Embeddable (entidade fraca) com Telefone
    // @CollectionTable define a tabela que armazenara os numeros de telefone

    @ElementCollection
    @CollectionTable(name = "TELEFONE", joinColumns = @JoinColumn(name = "CLIENTE_ID"))
    private Set<Telefone> telefones = new HashSet<>();

}
