package org.example.movimentacao.enums;

import lombok.AllArgsConstructor;


@AllArgsConstructor
public enum TipoMovimentacao {

    APORTE(1, "Aporte"),
    RESGATE(2, "Resgate");

    private final long id;
    private final String description;

}

