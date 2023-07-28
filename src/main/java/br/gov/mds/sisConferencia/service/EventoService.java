package br.gov.mds.sisConferencia.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Eixo;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.models.EventoEixoId;
import br.gov.mds.sisConferencia.repository.ArquivoRepository;
import br.gov.mds.sisConferencia.repository.EixoRepository;
import br.gov.mds.sisConferencia.repository.EventoRepository;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;
import br.gov.mds.sisConferencia.service.request.EventoRequest;

@Service
public class EventoService extends GenericService<Evento, Long, EventoDTO> {

	
	private final EventoMapper eventoMapper;

	
	private final EixoRepository eixoRepository;
	
	
	private final ArquivoRepository arquivoRepository;

	public EventoService(EventoRepository repository, EventoMapper mapper, ArquivoRepository arquivoRepository, EixoRepository eixoRepository) {
		super(repository, mapper);
		this.eventoMapper = mapper;
		this.eixoRepository = eixoRepository;
		this.arquivoRepository = arquivoRepository;
	}
	
	@Transactional
	public EventoDTO salvar(EventoRequest eventoRequest) {
	    Evento evento = eventoMapper.requestToEntity(eventoRequest);
	    Arquivo save = arquivoRepository.save(evento.getImagem());
	    evento.setImagem(save);
	    Evento savedEvento = save(evento);

	    if (evento.getEixos() != null) {
	        List<Eixo> eixos = evento.getEixos();
	        List<Eixo> savedEixos = new ArrayList<>();

	        for (Eixo eixo : eixos) {

	            EventoEixoId idEventoEixo = new EventoEixoId();
	            idEventoEixo.setEventoId(savedEvento.getId()); // Use evento.getId() aqui, não savedEvento.getId()
				idEventoEixo.setNumeroEixo(eixo.getNumero());
				eixo.setId(idEventoEixo);
				savedEixos.add(eixo);
	        }

	        eixoRepository.saveAll(savedEixos);
	        evento.setEixos(savedEixos);
	    }


	    return mapper.toDto(savedEvento);
	}



	@Transactional
	public EventoDTO atualizar(Long id, EventoDTO eventoAtualizado) {
		if (repository.existsById(id)) {
			return atualizar(mapper.toDto(mapper.toEntity(eventoAtualizado)));
		} else {
			throw new SisConferenciaNotFoundException("Não encontrado.");
		}
	}

}
