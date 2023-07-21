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

    private String nome;
    
    private String objetivo;

    private String tema;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;
    
    private Boolean ativo;

    private TipoEventoDTO tipoEvento;

    private TipoFormatoDTO tipoFormato;

    private PortariaDTO portaria;

    private List<EixoDTO> eixos;
}
