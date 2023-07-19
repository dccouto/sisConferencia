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
public class ConselhoDTO {

    private Long id;

    private String descricao;

    private String porte;

    private Long idMunicipio;

    private Long idEstado;

    private Long idIbge;

    private List<ConselheiroDTO> conselheiros;
}
