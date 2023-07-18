package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventoDTO {

    private Long id;

    private String descricao;

    private String tema;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;

    private TipoEventoDTO tipoEvento;

    private TipoRegimeDTO tipoRegime;

    private PortariaDTO portaria;

    private List<EixoDTO> eixos;
}
