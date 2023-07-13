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
@Table(name = "TB_ACOMPANHANTE", schema = Schemas.SISCONFERENCIA)
public class Acompanhante {

	@Id
	@Column(name = "PK_ACOMPANHANTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ACOMPANHANTE")
	@SequenceGenerator(name = "SQ_ACOMPANHANTE", sequenceName = "SQ_ACOMPANHANTE", allocationSize = 1)
	private Long id;

	@Column(name = "NO_PESSOA")
	private String nome;

	@Column(name = "NO_PESSOA_CRACHA")
	private String nomeCracha;

	@Column(name = "NU_RG")
	private String rg;

	@Column(name = "DS_ORGAO_EXPEDIDOR")
	private String orgaoExpedidor;

	@Column(name = "NU_CPF")
	private String cpf;

	@Column(name = "DS_EMAIL")
	private String email;

	@Column(name = "TP_SEXO")
	private String sexo;

	@ManyToOne
	@JoinColumn(name = "FK_ENDERECO", nullable = false)
	private Endereco endereco;

	@ManyToOne
	@JoinColumn(name = "FK_TELEFONE", nullable = true)
	private Telefone telefone;

	@ManyToOne
	@JoinColumn(name = "FK_INFORMACAO_COMPLEMENTAR", nullable = true)
	private InformacaoComplementar informacaoComplementar;

	@ManyToOne
	@JoinColumn(name = "FK_TP_DEFICIENCIA", nullable = false)
	private TipoDeficiencia tipoDeficiencia;

}
