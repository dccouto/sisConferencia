package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MenuPrincipalDTO {

    private Long id;

    private String menu;

    private String rota;

    //private List<Funcionalidade> funcionalidades;

    private List<SubmenuDTO> submenu;
}
