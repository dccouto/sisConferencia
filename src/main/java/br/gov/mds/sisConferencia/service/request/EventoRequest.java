package br.gov.mds.sisConferencia.service.request;

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Eixo;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import br.gov.mds.sisConferencia.service.dto.EixoDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventoRequest {
    private Long id;
    private String dataFinal;
    private String dataInicial;
    private String objetivo;
    private String nome;
    private Long portaria;
    private String tema;
    private ArquivoDTO imagem;
    private Long tipoEvento;
    private Long tipoFormato;
    private List<EixoDTO> eixos;
}
