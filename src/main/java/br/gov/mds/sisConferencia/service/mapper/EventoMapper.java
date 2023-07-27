package br.gov.mds.sisConferencia.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
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
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import br.gov.mds.sisConferencia.service.dto.TipoFormatoDTO;
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


    public Evento requestToEntity(EventoRequest eventoRequest) throws NotFoundException {
    	Evento evento =mapper.map(eventoRequest, Evento.class); 
    	
    	TipoEventoDTO tipoEventoDto = tipoEventoService.buscarPorID(eventoRequest.getTipoEvento());
    	TipoEvento tipoEvento = mapper.map(tipoEventoDto, TipoEvento.class);
    	evento.setTipoEvento(tipoEvento);
    	
    	TipoFormatoDTO tipoFormatoDto = tipoFormatoEventoService.buscarPorID(eventoRequest.getTipoFormato());
    	TipoFormato tipoFormato = mapper.map(tipoFormatoDto, TipoFormato.class);
    	evento.setTipoFormato(tipoFormato);
    	
    	PortariaDTO portariaDto = portairaService.buscarPorID(eventoRequest.getPortaria());
    	Portaria portaria = mapper.map(portariaDto, Portaria.class);
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
