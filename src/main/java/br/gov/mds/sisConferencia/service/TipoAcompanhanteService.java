package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.repository.TipoAcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;

@Service
public class TipoAcompanhanteService extends GenericService<TipoAcompanhante, Long, TipoAcompanhanteDTO> {
	@Autowired
	EntityMapper<TipoAcompanhanteDTO, TipoAcompanhante> entityMapper;

	public TipoAcompanhanteService(TipoAcompanhanteRepository repository,
			EntityMapper<TipoAcompanhanteDTO, TipoAcompanhante> mapper) {
		super(repository, mapper);
	}

	public TipoAcompanhanteDTO salvar(TipoAcompanhanteDTO tipoAcompanhanteDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(tipoAcompanhanteDTO)));
	}


	public TipoAcompanhante atualizar(Long id, TipoAcompanhante tipoAcompanhante) {
		TipoAcompanhante existingTipoAcompanhante = findById(id);
		existingTipoAcompanhante.setDescricao(tipoAcompanhante.getDescricao());
		return save(existingTipoAcompanhante);

	}


}
