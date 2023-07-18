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
@Table(name = "TB_SEGUIMENTO", schema = Schemas.SISCONFERENCIA)
public class Seguimento {
	
	@Id
	@Column(name = "PK_SEGUIMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SEGUIMENTO")
	@SequenceGenerator(name = "SQ_SEGUIMENTO", sequenceName = "SQ_SEGUIMENTO", allocationSize = 1)
    private Long id;

    
    @Column(name = "DS_DESCRICAO")
    private String descricao;

}
