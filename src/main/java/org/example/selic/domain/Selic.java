package org.example.cdi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.cdi.model.CdiInput;
import org.example.cdi.model.SelicInput;
import org.example.configuracaoativo.domain.ConfiguracaoAtivo;
import org.example.configuracaoativo.model.ConfiguracaoAtivoInput;
import org.example.movimentacao.enums.TipoMovimentacao;
import org.example.movimentacao.model.MovimentacaoInput;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "selic")
@Entity(name = "selic")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Selic {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_selic")
    @SequenceGenerator(name = "seq_selic", sequenceName = "seq_selic", allocationSize = 1)
    private Long id;

    private LocalDate data;

    private BigDecimal valor;

    public Selic(SelicInput input) {
        this.valor = input.valor();
        this.data = input.data();
    }
}

