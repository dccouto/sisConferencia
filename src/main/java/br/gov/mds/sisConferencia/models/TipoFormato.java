package br.gov.mds.sisConferencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mds.sisConferencia.models.interfaces.DomainGeneric;
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
@Table(name = "TB_TIPO_FORMATO", schema = Schemas.SISCONFERENCIA)
public class TipoFormato implements DomainGeneric {

	@Id
	@Column(name = "PK_TIPO_FORMATO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_FORMATO")
	@SequenceGenerator(name = "SQ_TIPO_FORMATO", sequenceName = "SQ_TIPO_FORMATO", allocationSize = 1)
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

}
