package org.example.configuracaoativo.model;

import java.math.BigDecimal;

public record ConfiguracaoAtivoInput(String nome, BigDecimal rendimentoDia, BigDecimal rendimentoMes, boolean somenteDiasUteis) {
}
