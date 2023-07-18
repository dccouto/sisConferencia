package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformacaoEventoDTO {

    private Long id;

    private String descricao;

    private EventoDTO evento;

    private TipoInscricaoDTO tipoInscricao;
}
