package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.interfaces.DomainGeneric;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public abstract class GenericService<T extends DomainGeneric, ID, DTO> {
	
	protected final JpaRepository<T, ID> repository;

	protected final EntityMapper<DTO, T> mapper;

	public GenericService(JpaRepository<T, ID> repository, EntityMapper<DTO, T> mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public T save(T entidade) {
		return repository.save(entidade);
	}

	public DTO salvar(DTO dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

	public void delete(ID id) {
		repository.deleteById(id);
	}

	public List<DTO> buscarTodos() {
		return mapper.toDto(repository.findAll()) ;
	}

	public List<T> findAll() {
		return repository.findAll();
	}

	public DTO buscarPorID(ID id) {
		return mapper.toDto(repository.findById(id).orElseThrow(() -> new SisConferenciaNotFoundException("Não encontrado.")));
	}

	public T findById(ID id) {
		return repository.findById(id)
				.orElseThrow(() -> new SisConferenciaNotFoundException("Não encontrado."));
	}

}
