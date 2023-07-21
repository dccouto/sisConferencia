package br.gov.mds.sisConferencia.models;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TB_PORTARIA", schema = Schemas.SISCONFERENCIA)
public class Portaria implements DomainGeneric {
	
	@Id
    @Column(name = "PK_PORTARIA")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PORTARIA")
    @SequenceGenerator(name = "SQ_PORTARIA", sequenceName = "SQ_PORTARIA", allocationSize = 1)
    private Long id;
	
    @Column(name = "NU_PORTARIA")
    private String numero;

    @Column(name = "DT_PORTARIA")
    private LocalDate dataPortaria;
    
    @Column(name = "DS_DESCRICAO")
    private String descricao;
    
    @ManyToOne
    @JoinColumn(name = "FK_DOCUMENTO")
    private Documento documento;


}
