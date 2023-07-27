package br.gov.mds.sisConferencia.service.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @JsonManagedReference
    private List<EixoDTO> eixos;

    private List<DocumentoDTO> documentos;
}
