package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoDTO {

        private Long id;

        private String logradouro;

        private String cep;

        private Long idMunicipio;

        private Long idEstado;

        private TipoEnderecoDTO tipoEndereco;
}
