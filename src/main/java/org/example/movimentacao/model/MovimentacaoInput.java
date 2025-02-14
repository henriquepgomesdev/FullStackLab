package org.example.movimentacao.model;

import org.example.movimentacao.enums.TipoMovimentacao;

import java.math.BigDecimal;

public record MovimentacaoInput(BigDecimal valor, TipoMovimentacao tipoMovimentacao) {
}
