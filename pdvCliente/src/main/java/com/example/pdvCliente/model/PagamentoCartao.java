package com.example.pdvCliente.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PAGAMENTOCARTAO")

public class PagamentoCartao extends Pagamento{

    @Column(name = "PARCELAS", length = 50, nullable = false)
    private Integer parcelas;

}
