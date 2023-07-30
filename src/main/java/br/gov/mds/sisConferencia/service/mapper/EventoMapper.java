package br.gov.mds.sisConferencia.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.models.TipoFormato;
import br.gov.mds.sisConferencia.service.PortariaService;
import br.gov.mds.sisConferencia.service.TipoEventoService;
import br.gov.mds.sisConferencia.service.TipoFormatoService;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.request.EventoRequest;

@Component
@ComponentScan
public class EventoMapper implements EntityMapper<EventoDTO, Evento> {

    private static ModelMapper mapper;
    
    @Autowired
    TipoEventoService tipoEventoService;
    
    @Autowired
    TipoFormatoService tipoFormatoEventoService;
    
    @Autowired
    PortariaService portairaService;
    
    
    
    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        EventoMapper.mapper = mapper;
    }

    @Override
    public Evento toEntity(EventoDTO eventoDTO) {
        return mapper.map(eventoDTO, Evento.class);
    }


    public Evento requestToEntity(EventoRequest eventoRequest) {
    	Evento evento = mapper.map(eventoRequest, Evento.class); 
    	
    	TipoEvento tipoEvento = tipoEventoService.findById(eventoRequest.getTipoEvento());
    	evento.setTipoEvento(tipoEvento);
    	
    	TipoFormato tipoFormato = tipoFormatoEventoService.findById(eventoRequest.getTipoFormato());
    	evento.setTipoFormato(tipoFormato);
    	
    	Portaria portaria = portairaService.findById(eventoRequest.getPortaria());
    	evento.setPortaria(portaria);
    	
        return evento;
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
