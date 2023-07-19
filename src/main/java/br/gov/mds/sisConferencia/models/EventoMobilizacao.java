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
@Table(name = "TB_EVENTO_MOBILIZACAO", schema = Schemas.SISCONFERENCIA)
public class EventoMobilizacao {

	@Id
	@Column(name = "PK_EVENTO_MOBILIZACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO_MOBILIZACAO")
	@SequenceGenerator(name = "SQ_EVENTO_MOBILIZACAO", sequenceName = "SQ_EVENTO_MOBILIZACAO", allocationSize = 1)
	private Long id;

	@Column(name = "QTD_EVENTO")
	private Integer quantidadeEvento;

	@Column(name = "QTD_PESSOAS_ENVOLVIDAS")
	private Integer quantidadePessoasEnvolvidas;

	@Column(name = "QTD_PARTICIPANTES")
	private Integer quantidadeParticipantes;

	@Column(name = "DS_OUTRAS_FORMAS")
	private String outrasFormas;
	
	@ManyToOne
	@JoinColumn(name = "PK_EVENTO")
	private Long idEvento;

	@ManyToOne
	@JoinColumn(name = "PK_TIPO_EVENTO_MOBILIZACAO")
	private TipoEventoMobilizacao tipoEventoMobilizacao;

	@ManyToOne
	@JoinColumn(name = "PK_RELATORIO_EVENTO")
	private RelatorioEvento relatorioEvento;
}
