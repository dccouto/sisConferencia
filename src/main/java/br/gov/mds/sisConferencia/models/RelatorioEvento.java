package br.gov.mds.sisConferencia.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
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
@Table(name = "TB_RELATORIO_EVENTO", schema = Schemas.SISCONFERENCIA)
public class RelatorioEvento {
	
	@Id
	@Column(name = "PK_RELATORIO_EVENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_RELATORIO_EVENTO")
	@SequenceGenerator(name = "SQ_RELATORIO_EVENTO", sequenceName = "SQ_RELATORIO_EVENTO", allocationSize = 1)
	private Long id;
	
	@Column(name = "NO_RESPONSAVEL_REGISTRO")
	private String responsavelRegistro;
	
	@Column(name = "NO_RESPONSAVEL_REGISTRO")
	private String presidenteConselho;
	
	@Column(name = "QTD_MUNICIPIO")
	private Integer qtdMunicipio;
	
	@Column(name = "QTD_PARTICIPANTES")
	private Integer qtdParticipante;
	
	@Column(name = "QTD_HORAS_EVENTO")
	private Integer qtdHorasEvento;
	
	@Column(name = "QTD_DELEGADOS_GOVERNAMENTAIS")
	private Integer qtdDelegadosGovernamentais;
	
	@Column(name = "QTD_DELEGADOS_USUARIOS")
	private Integer qtdDelegadosUsuarios;
	
	@Column(name = "QTD_DELEGADOS_TRABALHADORES")
	private Integer qtdDelegadosTrabalhadores;
	
	@Column(name = "QTD_DELEGADOS_ENTIDADES")
	private Integer qtdDelegadosEntidades;
	
	@Column(name = "QTD_OBSERVADORES")
	private Integer qtdObservadores;
	
	@Column(name = "QTD_CONVIDADOS")
	private Integer qtdConvidados;
	
	@OneToMany
	@JoinColumn(name = "FK_EVENTO_MOBILIZACAO", nullable = false)
	private List<EventoMobilizacao> evento;
	
	@OneToMany(mappedBy = "relatorioEvento")
    @JoinColumn(name = "FK_CONSELHO", nullable = false)
	private List<Conselho> conselho;
    
    
	@OneToMany(mappedBy = "relatorioEvento")
    @JoinColumn(name = "FK_PESSOA_ENVOLVIDA_CONFERENCIA", nullable = false)
	private List<PessoaEnvolvidaConferencia> pessoaEnvolvidaConferencia;
	
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "RL_RELATORIO_DOCUMENTO", 
		joinColumns = @JoinColumn(name = "FK_RELATORIO_EVENTO"), 
		inverseJoinColumns = @JoinColumn(name = "FK_DOCUMENTO")
	)
	private List<Documento> documentos;

}
