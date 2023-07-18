package br.gov.mds.sisConferencia.service.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConselheiroDTO {

    private Long id;

    private ConselhoDTO conselho;

    private UsuarioDTO usuario;

    private TipoConselheiroDTO tipoConselheiro;
}
