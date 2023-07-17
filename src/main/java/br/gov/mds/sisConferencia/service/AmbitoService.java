package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.repository.AmbitoRepository;

@Service
public class AmbitoService extends GenericService<Ambito , Long> {

	public AmbitoService(AmbitoRepository repository) {
		super(repository);
	}


	public Ambito atualizar(Long id, Ambito ambito) {
		Ambito existingAmbito = findById(id);
		existingAmbito.setDescricao(ambito.getDescricao());
		return save(existingAmbito);

	}
}