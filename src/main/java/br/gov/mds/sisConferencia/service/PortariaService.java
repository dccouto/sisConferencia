package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.repository.PortariaRepository;

@Service
public class PortariaService extends GenericService<Portaria, Long> {

	public PortariaService(PortariaRepository repository) {
		super(repository);
	}

	public Portaria atualizar(Long id, Portaria portaria) {
		var existingPortaria = findById(id);
		existingPortaria.setNumero(portaria.getNumero());
		existingPortaria.setDataPortaria(portaria.getDataPortaria());
		existingPortaria.setDescricao(portaria.getDescricao());
		return save(existingPortaria);

	}

}
