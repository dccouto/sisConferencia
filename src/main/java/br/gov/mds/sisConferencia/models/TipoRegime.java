package br.gov.mds.sisConferencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "TB_TIPO_REGIME", schema = Schemas.SISCONFERENCIA)
public class TipoRegime {

	@Id
	@Column(name = "PK_TIPO_REGIME")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_REGIME")
	@SequenceGenerator(name = "SQ_TIPO_REGIME", sequenceName = "SQ_TIPO_REGIME", allocationSize = 1)
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

}
