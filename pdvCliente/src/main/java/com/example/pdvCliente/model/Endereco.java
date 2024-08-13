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
@Table(name = "ENDERECO")

public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "LOGRADOURO", length = 50, nullable = false)
    private String logradouro;

    @Column(name = "NUMERO", length = 100, nullable = false)
    private String numero;

    @Column(name = "COMPLEMENTO", length = 50, nullable = false)
    private String complemento;

    @Column(name = "BAIRRO", length = 50, nullable = false)
    private String bairro;

    @Column(name = "CEP", length = 50, nullable = false)
    private String cep;

    // Relacionamento ManyToOne com Cliente
    // CLIENTE_ID é a chave estrangeira que relaciona Cliente - Endereco

    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID", nullable = false)
    private Cliente cliente;

    // Relacionamento ManyToOne com Cidade
    @ManyToOne
    @JoinColumn(name = "CIDADE_ID", nullable = false)
    private Cidade cidade;

}
