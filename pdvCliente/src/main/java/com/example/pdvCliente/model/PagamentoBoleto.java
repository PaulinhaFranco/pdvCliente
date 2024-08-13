package com.example.pdvCliente.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;


@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "PAGAMENTOBOLETO")

public class PagamentoBoleto extends Pagamento{

    @Column(name = "DATAVENCIMENTO", length = 50, nullable = false)
    private Date dataVencimento;

    @Column(name = "DATAPAGAMENTO", length = 50, nullable = false)
    private Date dataPagamento;
}
