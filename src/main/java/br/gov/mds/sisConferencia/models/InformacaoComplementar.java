package br.gov.mds.sisConferencia.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
@Table(name = "TB_INFORMACAO_COMPLEMENTAR", schema = Schemas.SISCONFERENCIA)
public class InformacaoComplementar {

	@Id
	@Column(name = "PK_INFORMACAO_COMPLEMENTAR")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_INFORMACAO_COMPLEMENTAR")
	@SequenceGenerator(name = "SQ_INFORMACAO_COMPLEMENTAR", sequenceName = "SQ_INFORMACAO_COMPLEMENTAR", allocationSize = 1)
	private Long id;

	@Column(name = "DS_DESCRICAO")
	private String descricao;

	@JsonIgnore
	@ManyToMany(mappedBy = "informacoesComplementares")
	private List<Inscricao> inscricoes;

}
