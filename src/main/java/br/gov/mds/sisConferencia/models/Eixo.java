package br.gov.mds.sisConferencia.models;
import javax.persistence.*;

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
@Table(name = "TB_EIXO", schema = Schemas.SISCONFERENCIA)
public class Eixo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EIXO")
	@SequenceGenerator(name = "SQ_EIXO", sequenceName = "SQ_EIXO", allocationSize = 1)
	@Column(name = "PK_EIXO")
    private Long id;

	@Column(name = "NU_EIXO")
	private Long numero;

	@Column(name = "DS_TEMA")
	private String tema;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@Column(name = "DS_EMENTA")
	private String ementa;

	@ManyToOne
	@JoinColumn(name = "FK_EVENTO", nullable = false)
	private Evento evento;
	}
