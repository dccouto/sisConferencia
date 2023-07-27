package br.gov.mds.sisConferencia.models;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mds.sisConferencia.enums.TipoJurisdicaoEnum;
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
@Table(name = "TB_DELIBERACAO", schema = Schemas.SISCONFERENCIA)
public class Deliberacao {

	@Id
	@Column(name = "PK_DELIBERACAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DELIBERACAO")
	@SequenceGenerator(name = "SQ_DELIBERACAO", sequenceName = "SQ_DELIBERACAO", allocationSize = 1)
    private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@Column(name = "NU_DELIBERACAO")
	private Long numero;

	@Column(name = "TP_PARA")
	@Enumerated(EnumType.ORDINAL)
	private TipoJurisdicaoEnum para;

	@ManyToOne
	@JoinColumn(name = "FK_RELATORIO_EVENTO")
	private RelatorioEvento relatorioEvento;

	@ManyToOne
	@JoinColumn(name = "FK_EIXO")
	private Eixo eixo;
}
