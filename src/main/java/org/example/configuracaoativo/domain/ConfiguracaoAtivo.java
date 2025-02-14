package org.example.configuracaoativo.domain;

import jakarta.persistence.*;
import lombok.*;
import org.example.configuracaoativo.model.ConfiguracaoAtivoInput;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.List;

@Table(name = "configuracao_ativo")
@Entity(name = "configuracao_ativo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ConfiguracaoAtivo {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_configuracao_ativo")
    @SequenceGenerator(name = "seq_configuracao_ativo", sequenceName = "seq_configuracao_ativo", allocationSize = 1)
    private Long id;

    private String nome;

    private BigDecimal rendimentoDia;

    private BigDecimal rendimentoMes;

    private boolean somenteDiasUteis;

    public ConfiguracaoAtivo(ConfiguracaoAtivoInput input) {
        this.nome = input.nome();
        this.rendimentoDia = input.rendimentoDia();
        this.rendimentoMes = input.rendimentoMes();
        this.somenteDiasUteis = input.somenteDiasUteis();
    }
}
