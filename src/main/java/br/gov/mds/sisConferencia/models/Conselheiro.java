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
@Table(name = "TB_CONSELHEIRO", schema = Schemas.SISCONFERENCIA)
public class Conselheiro {
	
	@Id
    @Column(name = "PK_ENDERECO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ENDERECO")
    @SequenceGenerator(name = "SQ_ENDERECO", sequenceName = "SQ_ENDERECO", allocationSize = 1)
    private Long id;
	
    @ManyToOne
    @JoinColumn(name = "FK_CONSELHO", nullable = false)
    private Conselho conselho;
    
    @ManyToOne
    @JoinColumn(name = "FK_USUARIO", nullable = false)
    private Usuario usuario;
    
    @ManyToOne
    @JoinColumn(name = "FK_TP_CONSELHEIRO", nullable = false)
    private TipoConselheiro tipoConselheiro;
    

}
