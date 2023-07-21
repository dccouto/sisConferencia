package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.repository.TipoAcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoAcompanhanteMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TipoAcompanhanteService extends GenericService<TipoAcompanhante, Long, TipoAcompanhanteDTO> {

	public TipoAcompanhanteService(TipoAcompanhanteRepository repository, TipoAcompanhanteMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public TipoAcompanhante atualizar(Long id, TipoAcompanhante tipoAcompanhante) {
		TipoAcompanhante existingTipoAcompanhante = findById(id);
		existingTipoAcompanhante.setDescricao(tipoAcompanhante.getDescricao());
		return save(existingTipoAcompanhante);

	}


}
