package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrgaoDTO {

    private Long id;

    private String nome;

    private String areaAtuacao;

    private String cargoAtuante;

    private String email;

    private Boolean isConselheiro;

    private EnderecoDTO endereco;

    private TelefoneDTO telefone;

    private TipoRepresentacaoDTO tipoRepresentacao;

    private SeguimentoDTO seguimento;

    private AmbitoDTO ambito;

    private ConselhoDTO conselho;
}
