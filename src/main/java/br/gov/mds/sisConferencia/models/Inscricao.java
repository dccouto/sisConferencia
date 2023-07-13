package br.gov.mds.sisConferencia.models;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mds.sisConferencia.util.Schemas;
import br.gov.mds.sisConferencia.util.converter.SimNaoConverter;
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
@Table(name = "TB_INSCRICAO", schema = Schemas.SISCONFERENCIA)
public class Inscricao {

	@Id

	@Column(name = "PK_INSCRICAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INSCRICAO")
	@SequenceGenerator(name = "SQ_INSCRICAO", sequenceName = "SQ_INSCRICAO", allocationSize = 1)
	private Long id;

	@Column(name = "DT_INSCRICAO")
	private LocalDateTime dataInscricao;

	@Convert(converter = SimNaoConverter.class)
	@Column(name = "ST_ATIVO")
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "FK_EVENTO", nullable = false)
	private Evento evento;

	@ManyToOne
	@JoinColumn(name = "FK_TIPO_INSCRICAO", nullable = false)
	private TipoInscricao tipoInscricao;

	@ManyToOne
	@JoinColumn(name = "FK_PARTICIPANTE", nullable = false)
	private Usuario participante;

	@ManyToOne
	@JoinColumn(name = "FK_ACOMPANHANTE", nullable = true)
	private Acompanhante acompanhante;

	@ManyToOne
	@JoinColumn(name = "FK_TP_ACOMPANHANTE", nullable = true)
	private TipoAcompanhante tipoAcompanhante;

	@ManyToOne
	@JoinColumn(name = "FK_ORGAO_INSCRICAO", nullable = false)
	private Orgao orgao;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "RL_INSCRICAO_INFORMACAO_COMPLEMENTAR", 
		joinColumns = @JoinColumn(name = "FK_INSCRICAO"), 
		inverseJoinColumns = @JoinColumn(name = "FK_INFORMACAO_COMPLEMENTAR")
	)
	private List<InformacaoComplementar> informacoesComplementares;

}
