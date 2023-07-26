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
@Table(name = "TB_AVALIACAO", schema = Schemas.SISCONFERENCIA)
public class Avaliacao {

	@Id
	@Column(name = "PK_AVALIACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_AVALIACAO")
	@SequenceGenerator(name = "SQ_AVALIACAO", sequenceName = "SQ_AVALIACAO", allocationSize = 1)
	private Long id;
	
	@Column(name = "NU_QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "DS_DESCRICAO")
	private String descricao;
	
	@ManyToOne
	@JoinColumn(name = "FK_ASSUNTO_AVALIACAO", nullable = true)
	private AssuntoAvaliacao assuntoAvaliacao;
	
	@ManyToOne
	@JoinColumn(name = "FK_RELATORIO_EVENTO", nullable = true)
	private RelatorioEvento relatorioEvento;
	
	@ManyToOne
	@JoinColumn(name = "FK_NOTA", nullable = true)
	private Nota nota;
	
	@ManyToOne
	@JoinColumn(name = "FK_TP_AVALIACAO", nullable = true)
	private TipoAvaliacao tipoAvaliacao;

}
