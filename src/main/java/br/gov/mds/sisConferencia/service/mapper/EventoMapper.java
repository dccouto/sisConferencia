package br.gov.mds.sisConferencia.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;

@Component
@ComponentScan
public class EventoMapper implements EntityMapper<EventoDTO, Evento> {

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        EventoMapper.mapper = mapper;
    }

    @Override
    public Evento toEntity(EventoDTO eventoDTO) {
        return mapper.map(eventoDTO, Evento.class);
    }

    @Override
    public EventoDTO toDto(Evento evento) {
        return mapper.map(evento, EventoDTO.class);
    }

    @Override
    public List<Evento> toEntity(List<EventoDTO> eventoDTOList) {
        return eventoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<EventoDTO> toDto(List<Evento> eventoList) {
        return eventoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
