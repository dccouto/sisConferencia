package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoParticipacao;
import br.gov.mds.sisConferencia.service.dto.TipoParticipacaoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoParticipacaoMapper implements EntityMapper<TipoParticipacaoDTO, TipoParticipacao>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoParticipacaoMapper.mapper = mapper;
    }

    @Override
    public TipoParticipacao toEntity(TipoParticipacaoDTO tipoParticipacaoDTO) {
        return mapper.map(tipoParticipacaoDTO, TipoParticipacao.class);
    }

    @Override
    public TipoParticipacaoDTO toDto(TipoParticipacao tipoParticipacao) {
        return mapper.map(tipoParticipacao, TipoParticipacaoDTO.class);
    }

    @Override
    public List<TipoParticipacao> toEntity(List<TipoParticipacaoDTO> tipoParticipacaoDTOList) {
        return tipoParticipacaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoParticipacaoDTO> toDto(List<TipoParticipacao> tipoParticipacaoList) {
        return tipoParticipacaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
