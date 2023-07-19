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
@Table(name = "TB_MUNICIPIO_AUSENTE", schema = Schemas.SISCONFERENCIA)
public class MunicipioAusente {
	
	@Id
	@Column(name = "PK_MUNICIPIO_AUSENTE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_MUNICIPIO_AUSENTE")
	@SequenceGenerator(name = "SQ_MUNICIPIO_AUSENTE", sequenceName = "SQ_MUNICIPIO_AUSENTE", allocationSize = 1)
    private Long id;

    @Column(name = "COD_MUNICIPIO")
    private Long idMunicipio;

    @Column(name = "DS_JUSTIFICATIVA")
    private String justificativa;
    
    @ManyToOne
    @JoinColumn(name = "PK_RELATORIO_EVENTO")
    private RelatorioEvento relatorioEvento;

}
