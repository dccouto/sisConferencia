package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Eixo;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.models.EventoEixoId;
import br.gov.mds.sisConferencia.repository.EixoRepository;
import br.gov.mds.sisConferencia.repository.EventoRepository;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;
import br.gov.mds.sisConferencia.service.request.EventoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventoService extends GenericService<Evento, Long, EventoDTO> {


	@Autowired
	EventoMapper eventoMapper;
	
	@Autowired
	EixoRepository eixoRepository;

	public EventoService(EventoRepository repository, EventoMapper mapper) {
		super(repository, mapper);
	}

	public EventoDTO salvar(EventoRequest eventoRequest) throws Exception {
	    try {
	        Evento evento = eventoMapper.requestToEntity(eventoRequest);
	        
	      
	        if (evento.getEixos() != null) {
	            for (Eixo eixo : evento.getEixos()) {
	                eixo.setEvento(evento);
	            }
	        }

	        Evento savedEvento = save(evento);
	 
	        if (savedEvento.getEixos() != null) {
	            for (Eixo eixo : savedEvento.getEixos()) {
	                eixo.setEvento(savedEvento);
	                EventoEixoId idEventoEixo = new EventoEixoId();
	                idEventoEixo.setEventoId(savedEvento.getId());
	                idEventoEixo.setEixoId(eixo.getId().getEixoId());  
	                eixo.setId(idEventoEixo);
	                eixoRepository.save(eixo); 
	            }
	        }

	        return mapper.toDto(savedEvento);
	    } catch (Exception e) {
	        e.printStackTrace();
	        throw e;
	    }
	}
	public EventoDTO atualizar(Long id, EventoDTO eventoAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(eventoAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}
