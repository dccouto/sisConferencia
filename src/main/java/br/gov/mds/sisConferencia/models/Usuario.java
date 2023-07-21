package br.gov.mds.sisConferencia.models;

import javax.persistence.*;

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
@Table(name = "TB_USUARIO", schema = Schemas.SISCONFERENCIA)
public class Usuario implements DomainGeneric {
	
    @Id
    @Column(name = "PK_USUARIO")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_USUARIO")
    @SequenceGenerator(name = "SQ_USUARIO", sequenceName = "SQ_USUARIO", allocationSize = 1)
	private Long id;
	
	@Column(name = "COD_PESSOA")
	private Long idPessoa;
	
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "FK_PERFIL", nullable = false)
	private Perfil perfil;


}
