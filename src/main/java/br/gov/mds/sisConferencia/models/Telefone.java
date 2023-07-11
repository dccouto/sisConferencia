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
@Table(name = "TB_TELEFONE", schema = Schemas.SISCONFERENCIA)
public class Telefone {
	
	@Id
    @Column(name = "PK_TELEFONE")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TELEFONE")
    @SequenceGenerator(name = "SQ_TELEFONE", sequenceName = "SQ_TELEFONE", allocationSize = 1)
    private Long id;
	
    @Column(name = "DS_TELEFONE")
    private String telefone;
    
    @Column(name = "DS_DDD")
    private Integer ddd;
    
    @ManyToOne
    @JoinColumn(name = "FK_TP_TELEFONE", nullable = true)
    private TipoTelefone tipoTelefone;
    
}
