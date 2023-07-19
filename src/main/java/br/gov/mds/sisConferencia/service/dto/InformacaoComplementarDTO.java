package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InformacaoComplementarDTO {

    private Long id;

    private String descricao;

    private List<InscricaoDTO> inscricoes;
}
