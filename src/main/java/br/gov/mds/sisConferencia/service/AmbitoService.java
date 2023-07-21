package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.repository.AmbitoRepository;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;

@Service
public class AmbitoService extends GenericService<Ambito, Long, AmbitoDTO> {

	public AmbitoService(AmbitoRepository repository, EntityMapper<AmbitoDTO, Ambito> mapper) {
		super(repository, mapper);
	}

	public AmbitoDTO salvar(AmbitoDTO ambitoDTO) {
		return mapper.toDto(save(mapper.toEntity(ambitoDTO)));
	}


	public Ambito atualizar(Long id, Ambito ambito) {
		Ambito existingAmbito = findById(id);
		existingAmbito.setDescricao(ambito.getDescricao());
		return save(existingAmbito);

	}
}