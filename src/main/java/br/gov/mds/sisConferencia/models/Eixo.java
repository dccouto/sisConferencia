package br.gov.mds.sisConferencia.models;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "TB_EIXO", schema = Schemas.SISCONFERENCIA)
public class Eixo {

    @EmbeddedId
    private EventoEixoId id;
		
	
	@Column(name = "NU_EIXO")
	private Long numero;

	@Column(name = "DS_TEMA")
	private String tema;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	
    @ManyToOne
    @JoinColumn(name = "FK_EVENTO", insertable = false, updatable = false)
    private Evento evento;

	@Column(name = "DS_EMENTA")
	private String ementa;

	/*@OneToMany(mappedBy = "eixo")
	private List<EventoEixo> eventoEixo;
	
	@OneToMany(mappedBy = "eixo")
	private List<Deliberacao> deliberacoes;*/
	}
