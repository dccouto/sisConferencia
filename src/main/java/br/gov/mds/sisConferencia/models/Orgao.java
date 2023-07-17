package br.gov.mds.sisConferencia.models;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
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
@Table(name = "TB_ORGAO_INSCRICAO", schema = Schemas.SISCONFERENCIA)
public class Orgao implements DomainGeneric {

	@Id
	@Column(name = "PK_ORGAO_INSCRICAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ORGAO_INSCRICAO")
	@SequenceGenerator(name = "SQ_ORGAO_INSCRICAO", sequenceName = "SQ_ORGAO_INSCRICAO", allocationSize = 1)
	private Long id;

	@Column(name = "NO_ORGAO")
	private String nome;

	@Column(name = "DS_AREA_ATUACAO")
	private String areaAtuacao;

	@Column(name = "DS_CARGO_ATUANTE")
	private String cargoAtuante;

	@Column(name = "DS_EMAIL")
	private String email;

	@Column(name = "ST_CONSELHEIRO")
	@Convert(converter = SimNaoConverter.class)
	private Boolean isConselheiro;

	@ManyToOne
	@JoinColumn(name = "FK_ENDERECO", nullable = false)
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "FK_TELEFONE", nullable = false)
	private Telefone telefone;

	@ManyToOne
	@JoinColumn(name = "FK_TP_REPRESENTACAO", nullable = false)
	private TipoRepresentacao tipoRepresentacao;

	@ManyToOne
	@JoinColumn(name = "FK_SEGUIMENTO", nullable = false)
	private Seguimento seguimento;

	@ManyToOne
	@JoinColumn(name = "FK_AMBITO", nullable = false)
	private Ambito ambito;

	@ManyToOne
	@JoinColumn(name = "FK_CONSELHO", nullable = false)
	private Conselho conselho;

}
