package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.EventoMobilizacao;
import br.gov.mds.sisConferencia.service.dto.EventoMobilizacaoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class EventoMobilizacaoMapper implements EntityMapper<EventoMobilizacaoDTO, EventoMobilizacao>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        EventoMobilizacaoMapper.mapper = mapper;
    }

    @Override
    public EventoMobilizacao toEntity(EventoMobilizacaoDTO eventoMobilizacaoDTO) {
        return mapper.map(eventoMobilizacaoDTO, EventoMobilizacao.class);
    }

    @Override
    public EventoMobilizacaoDTO toDto(EventoMobilizacao eventoMobilizacao) {
        return mapper.map(eventoMobilizacao, EventoMobilizacaoDTO.class);
    }

    @Override
    public List<EventoMobilizacao> toEntity(List<EventoMobilizacaoDTO> eventoMobilizacaoDTOList) {
        return eventoMobilizacaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoMobilizacaoDTO> toDto(List<EventoMobilizacao> eventoMobilizacaoList) {
        return eventoMobilizacaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}