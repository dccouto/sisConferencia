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
@Table(name = "TB_INFORMACAO_EVENTO", schema = Schemas.SISCONFERENCIA)
public class InformacaoEvento {
	
	@Id
    @Column(name = "PK_INFORMACAO_EVENTO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INFORMACAO_EVENTO")
    @SequenceGenerator(name = "SQ_INFORMACAO_EVENTO", sequenceName = "SQ_INFORMACAO_EVENTO", allocationSize = 1)
    private Long id;

    
    @Column(name = "DS_DESCRICAO")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "FK_EVENTO", nullable = false)
    private Evento evento;
    
    @ManyToOne
    @JoinColumn(name = "FK_TIPO_INSCRICAO", nullable = false)
    private TipoInscricao tipoInscricao;

}
