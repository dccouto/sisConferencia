package br.gov.mds.sisConferencia.service;

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

	public Ambito atualizar(Long id, Ambito ambito) {
		Ambito existingAmbito = findById(id);
		existingAmbito.setDescricao(ambito.getDescricao());
		return save(existingAmbito);

	}
}