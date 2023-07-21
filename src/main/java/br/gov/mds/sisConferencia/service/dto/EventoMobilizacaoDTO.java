package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.models.RelatorioEvento;
import br.gov.mds.sisConferencia.models.TipoEventoMobilizacao;
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
public class EventoMobilizacaoDTO {

    private Long id;

    private Integer quantidadeEvento;

    private Integer quantidadePessoasEnvolvidas;

    private Integer quantidadeParticipantes;

    private String outrasFormas;

    private Evento evento;

    private TipoEventoMobilizacao tipoEventoMobilizacao;

    private RelatorioEvento relatorioEvento;
}