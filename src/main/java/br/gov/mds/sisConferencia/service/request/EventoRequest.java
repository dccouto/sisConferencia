package br.gov.mds.sisConferencia.service.request;

import java.time.LocalDateTime;
import java.util.List;

import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import br.gov.mds.sisConferencia.service.dto.EixoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventoRequest {
    private Long id;
    private LocalDateTime dataFinal;
    private LocalDateTime dataInicial;
    private String objetivo;
    private String nome;
    private Long portaria;
    private String tema;
    private ArquivoDTO imagem;
    private Long tipoEvento;
    private Long tipoFormato;
    private List<EixoDTO> eixos;
}
