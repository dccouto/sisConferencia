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
public class InscricaoDTO {

    private Long id;

    private LocalDateTime dataInscricao;

    private Boolean ativo;

    private EventoDTO evento;

    private TipoInscricaoDTO tipoInscricao;

    private UsuarioDTO participante;

    private AcompanhanteDTO acompanhante;

    private TipoAcompanhanteDTO tipoAcompanhante;

    private OrgaoDTO orgao;

    private List<InformacaoComplementarDTO> informacoesComplementares;

}
