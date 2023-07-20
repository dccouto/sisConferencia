package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoRegime;
import br.gov.mds.sisConferencia.repository.TipoRegimeRepository;

@Service
public class TipoRegimeService extends GenericService<TipoRegime, Long> {

	public TipoRegimeService(TipoRegimeRepository repository) {
		super(repository);
	}

	public TipoRegime atualizar(Long id, TipoRegime tipoRegime) {
		TipoRegime existingTipoRegime = findById(id);
		existingTipoRegime.setDescricao(tipoRegime.getDescricao());
		return save(existingTipoRegime);

	}

}
