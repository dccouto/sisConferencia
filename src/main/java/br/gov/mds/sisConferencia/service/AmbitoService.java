package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.repository.AmbitoRepository;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import br.gov.mds.sisConferencia.service.mapper.AmbitoMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AmbitoService extends GenericService<Ambito , Long, AmbitoDTO> {

	public AmbitoService(AmbitoRepository repository, AmbitoMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public Ambito atualizar(Long id, Ambito ambito) {
		Ambito existingAmbito = findById(id);
		existingAmbito.setDescricao(ambito.getDescricao());
		return save(existingAmbito);

	}
}