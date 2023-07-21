package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.repository.AmbitoRepository;

import javax.transaction.Transactional;

@Service
public class AmbitoService extends GenericService<Ambito , Long> {

	@Autowired
	EntityMapper<AmbitoDTO, Ambito> entityMapper;

	@Transactional
	public AmbitoDTO salvar(AmbitoDTO ambitoDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(ambitoDTO)));
	}

	public AmbitoService(AmbitoRepository repository) {
		super(repository);
	}

	@Transactional
	public Ambito atualizar(Long id, Ambito ambito) {
		Ambito existingAmbito = findById(id);
		existingAmbito.setDescricao(ambito.getDescricao());
		return save(existingAmbito);

	}
}