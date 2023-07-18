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
@Table(name = "TB_EMENTA", schema = Schemas.SISCONFERENCIA)
public class Ementa {
	
	@Id
	@Column(name = "PK_EMENTA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EMENTA")
	@SequenceGenerator(name = "SQ_EMENTA", sequenceName = "SQ_EMENTA", allocationSize = 1)
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;
	


}
