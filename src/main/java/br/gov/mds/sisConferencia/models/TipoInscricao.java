package br.gov.mds.sisConferencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "TB_TIPO_INSCRICAO", schema = Schemas.SISCONFERENCIA)
public class TipoInscricao implements DomainGeneric {
	
    /**
     * Não terá sequence criada no banco de dados
     * */
    @Id
    @Column(name = "PK_TIPO_INSCRICAO")
    private Long id;
    
    @Column(name = "DS_DESCRICAO")
    private String descricao;

}
