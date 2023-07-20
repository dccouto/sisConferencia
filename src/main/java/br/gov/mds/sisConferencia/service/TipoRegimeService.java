package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.TipoRegime;
import br.gov.mds.sisConferencia.repository.TipoRegimeRepository;
import br.gov.mds.sisConferencia.service.dto.TipoRegimeDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoRegimeMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TipoRegimeService extends GenericService<TipoRegime, Long, TipoRegimeDTO> {

	public TipoRegimeService(TipoRegimeRepository repository, TipoRegimeMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public TipoRegime atualizar(Long id, TipoRegime tipoRegime) {
		TipoRegime existingTipoRegime = findById(id);
		existingTipoRegime.setDescricao(tipoRegime.getDescricao());
		return save(existingTipoRegime);

	}

}
