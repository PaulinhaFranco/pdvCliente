package com.example.pdvCliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

// A anotação @Embeddable indica que essa classe é um componente embutido e será utilizada como parte de outra entidade (neste caso, a entidade Cliente).
// Na classe Cliente, os telefones são mapeados como uma coleção de elementos (@ElementCollection)
// A anotação @ElementCollection na classe Cliente cria a tabela TELEFONE que associará números de telefone ao cliente via a chave estrangeira CLIENTE_ID.

@Embeddable
public class Telefone {

    @Column(name = "NUMERO", length = 50, nullable = false)
    private String numero;

}
