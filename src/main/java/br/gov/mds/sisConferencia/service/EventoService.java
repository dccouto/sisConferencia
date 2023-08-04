package br.gov.mds.sisConferencia.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import br.gov.mds.sisConferencia.service.dto.EixoDTO;
import br.gov.mds.sisConferencia.service.mapper.EixoMapper;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Eixo;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.repository.ArquivoRepository;
import br.gov.mds.sisConferencia.repository.EixoRepository;
import br.gov.mds.sisConferencia.repository.EventoRepository;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;
import br.gov.mds.sisConferencia.service.request.EventoRequest;

@Service
public class EventoService extends GenericService<Evento, Long, EventoDTO> {

	
	private final EventoMapper eventoMapper;

	private final EixoMapper eixoMapper;
	private final EixoRepository eixoRepository;
	
	
	private final ArquivoRepository arquivoRepository;

	public EventoService(EventoRepository repository, EventoMapper mapper, ArquivoRepository arquivoRepository,
						 EixoRepository eixoRepository, EixoMapper eixoMapper ) {
		super(repository, mapper);
		this.eventoMapper = mapper;
		this.eixoRepository = eixoRepository;
		this.arquivoRepository = arquivoRepository;
		this.eixoMapper = eixoMapper;
	}
	
	@Transactional
	public EventoDTO salvar(EventoRequest eventoRequest) {
	    Evento evento = eventoMapper.requestToEntity(eventoRequest);
	    Arquivo save = arquivoRepository.save(evento.getImagem());
	    evento.setImagem(save);
	    Evento savedEvento = save(evento);

	    if (eventoRequest.getEixos() != null) {
	        List<Eixo> savedEixos = new ArrayList<>();

	        for (EixoDTO eixoDTO : eventoRequest.getEixos()) {
				Eixo eixo = eixoMapper.toEntity(eixoDTO);
				eixo.setEvento(savedEvento);

				savedEixos.add(eixo);
	        }

			savedEixos = eixoRepository.saveAll(savedEixos);
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
