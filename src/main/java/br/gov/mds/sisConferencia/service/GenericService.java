package br.gov.mds.sisConferencia.service;

import java.util.List;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.interfaces.DomainGeneric;

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
	
	public T saveDTO(DTO dto) {
		return repository.save(mapper.toEntity(dto));
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
