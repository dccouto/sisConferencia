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
@Table(name = "TB_SUBMENU_PRINCIPAL_CONFIG", schema = Schemas.SISCONFERENCIA)
public class Submenu {
	
	@Id
    @Column(name = "PK_SUBMENU_PRINCIPAL_CONFIG")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_SUBMENU_PRINCIPAL_CONFIG")
    @SequenceGenerator(name = "SQ_SUBMENU_PRINCIPAL_CONFIG", sequenceName = "SQ_SUBMENU_PRINCIPAL_CONFIG", allocationSize = 1)
	private Long id;
	
	@Column(name = "DS_DESCRICAO")
	private String menu;
	
	@Column(name = "DS_ROTA")
	private String rota;
	
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "FK_MENU_PRINCIPAL_CONFIG", nullable = false)
    private MenuPrincipal menuPrincipal;

}
