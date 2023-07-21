package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.repository.TipoEventoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;

@Service
public class TipoEventoService extends GenericService<TipoEvento , Long, TipoEventoDTO> {

	public TipoEventoService(TipoEventoRepository repository,
			EntityMapper<TipoEventoDTO, TipoEvento> mapper) {
		super(repository, mapper);
	}

	public TipoEvento atualizar(Long id, TipoEvento tipoEvento) {
		TipoEvento existingTipoEvento = findById(id);
		existingTipoEvento.setDescricao(tipoEvento.getDescricao());
		return save(existingTipoEvento);

	}
}