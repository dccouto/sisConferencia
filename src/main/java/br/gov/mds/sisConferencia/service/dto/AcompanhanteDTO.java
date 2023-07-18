package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AcompanhanteDTO {

        private Long id;

        private String nome;

        private String nomeCracha;

        private String rg;

        private String orgaoExpedidor;

        private String cpf;

        private String email;

        private String sexo;

        private EnderecoDTO endereco;

        private TelefoneDTO telefone;

        private InformacaoComplementarDTO informacaoComplementar;

        private TipoDeficienciaDTO tipoDeficiencia;
}
