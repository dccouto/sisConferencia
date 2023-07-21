package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.repository.TipoEventoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoEventoMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TipoEventoService extends GenericService<TipoEvento , Long, TipoEventoDTO> {

	public TipoEventoService(TipoEventoRepository repository, TipoEventoMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public TipoEvento atualizar(Long id, TipoEvento tipoEvento) {
		TipoEvento existingTipoEvento = findById(id);
		existingTipoEvento.setDescricao(tipoEvento.getDescricao());
		return save(existingTipoEvento);

	}
}