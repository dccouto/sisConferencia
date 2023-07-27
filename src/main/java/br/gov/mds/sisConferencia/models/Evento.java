package br.gov.mds.sisConferencia.models;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import br.gov.mds.sisConferencia.models.interfaces.DomainGeneric;
import br.gov.mds.sisConferencia.util.Schemas;
import br.gov.mds.sisConferencia.util.converter.SimNaoConverter;
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
public class Evento implements DomainGeneric {

	@Id
	@Column(name = "PK_EVENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_EVENTO")
	@SequenceGenerator(name = "SQ_EVENTO", sequenceName = "SQ_EVENTO", allocationSize = 1)
	private Long id;

	@Column(name = "NO_EVENTO")
	private String nome;

	@Column(name = "DS_OBJETIVO", length = 500)
	private String objetivo;

	@Column(name = "DS_TEMA")
	private String tema;

	@Column(name = "DT_CADASTRO")
	private LocalDateTime dataCadastro;

	@Column(name = "DT_INICIAL")
	private LocalDateTime dataInicial;

	@Column(name = "DT_FINAL")
	private LocalDateTime dataFinal;

	@Convert(converter = SimNaoConverter.class)
	@Column(name = "ST_ATIVO")
	private Boolean ativo;

	@ManyToOne
	@JoinColumn(name = "FK_TIPO_EVENTO", nullable = true)
	private TipoEvento tipoEvento;

	@ManyToOne
	@JoinColumn(name = "FK_TIPO_FORMATO", nullable = true)
	private TipoFormato tipoFormato;

	@ManyToOne
	@JoinColumn(name = "FK_PORTARIA", nullable = true)
	private Portaria portaria;

    @ManyToOne
    @JoinColumn(name = "PK_ARQUIVO", nullable = true)
    private Arquivo imagem;
    
    @JsonManagedReference
	@OneToMany(mappedBy = "evento")
	private List<Eixo> eixos;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "RL_EVENTO_DOCUMENTO", 
		joinColumns = @JoinColumn(name = "FK_EVENTO"), 
		inverseJoinColumns = @JoinColumn(name = "FK_DOCUMENTO")
	)
	

	private List<Documento> documentos;
	

    @PrePersist
    public void prePersist() {
    	if(dataCadastro == null) {
    		// Define a dataCadastro antes de persistir a entidade no banco de dados
    		dataCadastro = LocalDateTime.now();
    	}
    }
}
