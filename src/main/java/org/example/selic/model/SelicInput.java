package org.example.cdi.model;

import java.math.BigDecimal;
import java.time.LocalDate;

public record SelicInput(BigDecimal valor, LocalDate data) {
}
