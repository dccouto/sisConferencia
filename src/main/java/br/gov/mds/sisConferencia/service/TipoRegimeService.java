package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoRegimeDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoRegimeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoRegime;
import br.gov.mds.sisConferencia.repository.TipoRegimeRepository;

import javax.transaction.Transactional;

@Service
public class TipoRegimeService extends GenericService<TipoRegime, Long, TipoRegimeDTO> {

	@Autowired
	EntityMapper<TipoRegimeDTO, TipoRegime> entityMapper;

	@Transactional
	public TipoRegimeDTO salvar(TipoRegimeDTO tipoRegimeDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(tipoRegimeDTO)));
	}

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
