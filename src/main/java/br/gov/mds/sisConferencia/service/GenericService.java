package br.gov.mds.sisConferencia.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.interfaces.DomainGeneric;

public abstract class GenericService<T extends DomainGeneric, ID> {
	
	protected final JpaRepository<T, ID> repository;

	public GenericService(JpaRepository<T, ID> repository) {
		this.repository = repository;
	}
	
	public T save(T entidade) {
		return repository.save(entidade);
	}

	public void delete(ID id) {
		repository.deleteById(id);
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public T findById(ID id) {
		return repository.findById(id)
				.orElseThrow(() -> new SisConferenciaNotFoundException("Não encontrado."));
	}

}
