package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.RelatorioEvento;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MunicipioAusenteDTO {

    private Long id;

    private Long idMunicipio;

    private String justificativa;

    private RelatorioEvento relatorioEvento;
}