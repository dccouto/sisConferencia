package br.gov.mds.sisConferencia.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import br.gov.mds.sisConferencia.models.interfaces.DomainGeneric;
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
@Table(name = "TB_ARQUIVO", schema = Schemas.SISCONFERENCIA)
public class Arquivo implements DomainGeneric {
	
	@Id
	@Column(name = "PK_ARQUIVO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ARQUIVO")
	@SequenceGenerator(name = "SQ_ARQUIVO", sequenceName = "SQ_ARQUIVO", allocationSize = 1)
    private Long id;
	
	@Column(name = "NO_ARQUIVO", length = 250)
	private String nome;

	@Column(name = "DS_DESCRICAO", length = 50)
	private String extensao;

    @Lob
    @Column(name = "BYTE_ARQUIVO")
    private byte[] byteArquivo;

}
