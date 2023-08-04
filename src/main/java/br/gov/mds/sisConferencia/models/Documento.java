package br.gov.mds.sisConferencia.models;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
@Table(name = "TB_DOCUMENTO", schema = Schemas.SISCONFERENCIA)
public class Documento {
	
	@Id
	@Column(name = "PK_DOCUMENTO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_DOCUMENTO")
	@SequenceGenerator(name = "SQ_DOCUMENTO", sequenceName = "SQ_DOCUMENTO", allocationSize = 1)
    private Long id;

    @Column(name = "DATA_ENVIO")
    private LocalDate dataEnvio;

    @ManyToOne
    @JoinColumn(name = "FK_TIPO_DOCUMENTO")
    private TipoDocumento tipoDocumento;

    @ManyToOne
    @JoinColumn(name = "FK_ARQUIVO")
    private Arquivo arquivo;

    @ManyToOne
    @JoinColumn(name = "FK_USUARIO_ENVIO")
    private Usuario usuarioEnvio;
    
	@JsonIgnore
	@ManyToMany(mappedBy = "documentos")
	private List<RelatorioEvento> relatoriosEventos;

}
