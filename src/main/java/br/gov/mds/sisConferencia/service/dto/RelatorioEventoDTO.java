package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.Conselho;
import br.gov.mds.sisConferencia.models.Documento;
import br.gov.mds.sisConferencia.models.EventoMobilizacao;
import br.gov.mds.sisConferencia.models.PessoaEnvolvidaConferencia;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RelatorioEventoDTO {

    private Long id;

    private String responsavelRegistro;

    private String presidenteConselho;

    private Integer qtdMunicipio;

    private Integer qtdParticipante;

    private Integer qtdHorasEvento;

    private Integer qtdDelegadosGovernamentais;

    private Integer qtdDelegadosUsuarios;

    private Integer qtdDelegadosTrabalhadores;

    private Integer qtdDelegadosEntidades;

    private Integer qtdObservadores;

    private Integer qtdConvidados;

    private List<EventoMobilizacao> eventosMobilizacoes;

    private List<Conselho> conselho;

    private List<PessoaEnvolvidaConferencia> pessoaEnvolvidaConferencia;

    private List<Documento> documentos;
}