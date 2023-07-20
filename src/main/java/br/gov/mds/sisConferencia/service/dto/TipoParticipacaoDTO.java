package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.TipoParticipacao;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoParticipacaoDTO {

    private Long id;

    private String descricao;

    @JsonIgnore
    private TipoParticipacao tipoParticipacaoPai;
}