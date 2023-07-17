package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.repository.TipoAcompanhanteRepository;

@Service
public class TipoAcompanhanteService extends GenericService<TipoAcompanhante, Long> {
	

	public TipoAcompanhanteService(TipoAcompanhanteRepository repository) {
		super(repository);
	}
	

	public TipoAcompanhante atualizar(Long id, TipoAcompanhante tipoAcompanhante) {
		TipoAcompanhante existingTipoAcompanhante = findById(id);
		existingTipoAcompanhante.setDescricao(tipoAcompanhante.getDescricao());
		return save(existingTipoAcompanhante);

	}


}
