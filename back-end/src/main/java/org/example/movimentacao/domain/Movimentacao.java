package org.example.movimentacao.domain;

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
import org.example.configuracaoativo.domain.ConfiguracaoAtivo;
import org.example.configuracaoativo.model.ConfiguracaoAtivoInput;
import org.example.movimentacao.enums.TipoMovimentacao;
import org.example.movimentacao.model.MovimentacaoInput;

import java.math.BigDecimal;
import java.time.LocalDate;

@Table(name = "movimentacao")
@Entity(name = "movimentacao")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Movimentacao {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_movimentacao")
    @SequenceGenerator(name = "seq_movimentacao", sequenceName = "seq_movimentacao", allocationSize = 1)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY) // Define o relacionamento ManyToOne
    @JoinColumn(name = "configuracao_ativo_id") // Nome da coluna na tabela Movimentacao
    private ConfiguracaoAtivo configuracaoAtivo;  // Relacionamento com ConfiguracaoAtivo

    private BigDecimal valor;

    private LocalDate data;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao; // Relacionamento com TipoMovimentacao (já configurado corretamente)


    public Movimentacao(MovimentacaoInput input, ConfiguracaoAtivo configuracaoAtivo) {
        this.configuracaoAtivo = configuracaoAtivo;
        this.valor = input.valor();
        this.tipoMovimentacao = input.tipoMovimentacao();
    }
}

