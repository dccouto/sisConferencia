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
@Table(name = "TB_PESSOA_ENVOLVIDA_CONFERENCIA", schema = Schemas.SISCONFERENCIA)
public class PessoaEnvolvidaConferencia {
	
	@Id
	@Column(name = "PK_PESSOA_ENVOLVIDA_CONFERENCIA")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_PESSOA_ENVOLVIDA_CONFERENCIA")
	@SequenceGenerator(name = "SQ_PESSOA_ENVOLVIDA_CONFERENCIA", sequenceName = "SQ_PESSOA_ENVOLVIDA_CONFERENCIA", allocationSize = 1)
    private Long id;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "DS_OUTROS")
	private String outros;

    @ManyToOne
    @JoinColumn(name = "FK_TIPO_PARTICIPACAO")
    private TipoParticipacao tipoParticipacao;

    @ManyToOne
    @JoinColumn(name = "FK_RELATORIO_EVENTO")
    private RelatorioEvento relatorioEvento;

}

