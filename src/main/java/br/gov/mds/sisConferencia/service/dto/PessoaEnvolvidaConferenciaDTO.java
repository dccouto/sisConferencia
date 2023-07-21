package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.RelatorioEvento;
import br.gov.mds.sisConferencia.models.TipoParticipacao;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PessoaEnvolvidaConferenciaDTO {

    private Long id;

    private Integer quantidade;

    private String outros;

    private TipoParticipacao tipoParticipacao;

    private RelatorioEvento relatorioEvento;
}
