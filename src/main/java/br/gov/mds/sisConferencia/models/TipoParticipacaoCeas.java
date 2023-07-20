package br.gov.mds.sisConferencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mds.sisConferencia.util.Schemas;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "TB_TIPO_PARTICIPACAO_CEAS", schema = Schemas.SISCONFERENCIA)
public class TipoParticipacaoCeas {
	
	@Id
	@Column(name = "PK_TIPO_PARTICIPACAO_CEAS")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_PARTICIPACAO_CEAS")
	@SequenceGenerator(name = "SQ_TIPO_PARTICIPACAO_CEAS", sequenceName = "SQ_TIPO_PARTICIPACAO_CEAS", allocationSize = 1)
    private Long id;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "PK_TIPO_PARTICIPACAO")
    private TipoParticipacao tipoParticipacao;

    @ManyToOne
    @JoinColumn(name = "PK_RELATORIO_EVENTO")
    private RelatorioEvento relatorioEvento;

}
