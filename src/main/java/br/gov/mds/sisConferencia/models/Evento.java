package br.gov.mds.sisConferencia.models;

import java.time.LocalDateTime;

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
@Table(name = "TB_EVENTO", schema = Schemas.SISCONFERENCIA)
public class Evento {
	
    @Id
    @Column(name = "PK_FORMULARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO")
    @SequenceGenerator(name = "SQ_EVENTO", sequenceName = "SQ_EVENTO", allocationSize = 1)
    private Long id;
    
    @Column(name = "DS_DESCRICAO")
    private String descricao;

    @Column(name = "DS_TEMA")
    private String tema;

    @Column(name = "DT_CADASTRO")
    private LocalDateTime dataCadastro;
    
    @Column(name = "DT_INICIAL")
    private LocalDateTime dataInicial;
    
    @Column(name = "DT_FINAL")
    private LocalDateTime dataFinal;
    
    @ManyToOne
    @JoinColumn(name = "FK_TIPO_EVENTO", nullable = false)
    private TipoEvento tipoEvento;
    
    @ManyToOne
    @JoinColumn(name = "FK_TIPO_REGIME", nullable = false)
    private TipoRegime tipoRegime;
}
