package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoAcompanhanteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.repository.TipoAcompanhanteRepository;

import javax.transaction.Transactional;

@Service
public class TipoAcompanhanteService extends GenericService<TipoAcompanhante, Long, TipoAcompanhanteDTO> {

	@Autowired
	EntityMapper<TipoAcompanhanteDTO, TipoAcompanhante> entityMapper;
	@Transactional
	public TipoAcompanhanteDTO salvar(TipoAcompanhanteDTO tipoAcompanhanteDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(tipoAcompanhanteDTO)));
	}

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
