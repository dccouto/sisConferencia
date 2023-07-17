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
@Table(name = "TB_TIPO_INSCRICAO", schema = Schemas.SISCONFERENCIA)
public class TipoInscricao implements DomainGeneric {
	
	@Id
	@Column(name = "PK_TIPO_INSCRICAO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TIPO_INSCRICAO")
	@SequenceGenerator(name = "SQ_TIPO_INSCRICAO", sequenceName = "SQ_TIPO_INSCRICAO", allocationSize = 1)
    private Long id;
    
    @Column(name = "DS_DESCRICAO")
    private String descricao;

}
