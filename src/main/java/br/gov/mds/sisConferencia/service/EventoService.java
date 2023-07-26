package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.repository.EventoRepository;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;
import br.gov.mds.sisConferencia.service.request.EventoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class EventoService extends GenericService<Evento, Long, EventoDTO> {


	@Autowired
	EventoMapper eventoMapper;

	public EventoService(EventoRepository repository, EventoMapper mapper) {
		super(repository, mapper);
	}

	public EventoDTO salvar(EventoRequest eventoRequest) {
		try {
			return saveDTO(mapper.toDto(eventoMapper.requestToEntity(eventoRequest)));
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

	@Transactional
	public EventoDTO atualizar(Long id, EventoRequest eventoRequest) {
		try {
			if ( eventoRequest.getId() != null && eventoRequest.getId().equals(id)) {
				return atualizar(mapper.toDto(eventoMapper.requestToEntity(eventoRequest)));
			} else {
				return salvar(eventoRequest);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}


}
