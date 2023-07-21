package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.repository.EventoRepository;

import javax.transaction.Transactional;

@Service
public class EventoService extends GenericService<Evento, Long, EventoDTO> {

	@Autowired
	EntityMapper<EventoDTO, Evento> entityMapper;

	@Transactional
	public EventoDTO salvar(EventoDTO eventoDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(eventoDTO)));
	}

	public EventoService(EventoRepository repository, EventoMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public Evento atualizar(Long id, Evento eventoAtualizado) {
		Evento existingEvento = findById(id);

		existingEvento.setNome(eventoAtualizado.getNome());
		existingEvento.setObjetivo(eventoAtualizado.getObjetivo());
		existingEvento.setTema(eventoAtualizado.getTema());
		existingEvento.setDataCadastro(eventoAtualizado.getDataCadastro());
		existingEvento.setDataInicial(eventoAtualizado.getDataInicial());
		existingEvento.setDataFinal(eventoAtualizado.getDataFinal());
		existingEvento.setAtivo(eventoAtualizado.getAtivo());
		existingEvento.setTipoEvento(eventoAtualizado.getTipoEvento());
		existingEvento.setTipoRegime(eventoAtualizado.getTipoRegime());
		existingEvento.setPortaria(eventoAtualizado.getPortaria());
		existingEvento.setEixos(eventoAtualizado.getEixos());
		existingEvento.setDocumentos(eventoAtualizado.getDocumentos());
		
		return save(existingEvento);
	}

}
