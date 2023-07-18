package br.gov.mds.sisConferencia.service.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SubmenuDTO {

    private Long id;

    private String menu;

    private String rota;

    @JsonIgnore
    private MenuPrincipalDTO menuPrincipal;
}
