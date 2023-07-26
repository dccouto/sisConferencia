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

	@EmbeddedId
	private EixoID id;

	@Column(name = "NU_EIXO")
	private Integer numero;

	@Column(name = "DS_TEMA")
	private String tema;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@ManyToOne
	@JoinColumn(name = "FK_EMENTA", nullable = false)
	private Ementa ementa;

}
