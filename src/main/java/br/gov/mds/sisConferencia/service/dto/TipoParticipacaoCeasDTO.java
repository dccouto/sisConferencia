package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.RelatorioEvento;
import br.gov.mds.sisConferencia.models.TipoParticipacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoParticipacaoCeasDTO {

    private Long id;

    private Integer quantidade;

    private TipoParticipacao tipoParticipacao;

    private RelatorioEvento relatorioEvento;
}
