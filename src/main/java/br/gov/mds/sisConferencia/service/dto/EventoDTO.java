package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Documento;
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

    private LocalDateTime dataInicial;

    private LocalDateTime dataFinal;
    
    private Boolean ativo;

    private TipoEventoDTO tipoEvento;

    private TipoFormatoDTO tipoFormato;

    private PortariaDTO portaria;

    private ArquivoDTO imagem;

    private List<EixoDTO> eixos;

    private List<DocumentoDTO> documentos;
}
