package br.gov.mds.sisConferencia.models;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
@Table(name = "TB_EIXO", schema = Schemas.SISCONFERENCIA)
public class Eixo {

    @EmbeddedId
    private EventoEixoId id;
    
	@Column(name = "NU_EIXO")
	private Integer numero;

	@Column(name = "DS_TEMA")
	private String tema;

	@Column(name = "DS_DESCRICAO")
	private String descricao;
	
	@JsonBackReference
	@ManyToOne
    @JoinColumn(name = "FK_EVENTO", insertable = false, updatable = false)
    private Evento evento;

	@ManyToOne
	@JoinColumn(name = "FK_EMENTA", nullable = false)
	@Cascade(CascadeType.ALL)
	private Ementa ementa;
	
	@OneToMany(mappedBy = "eixo")
	private List<EventoEixo> eventoEixo;
	
	@OneToMany(mappedBy = "eixo")
	private List<Deliberacao> deliberacoes;
}
