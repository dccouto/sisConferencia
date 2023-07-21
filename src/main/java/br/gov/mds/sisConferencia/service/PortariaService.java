package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;
import br.gov.mds.sisConferencia.service.mapper.PortariaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.repository.PortariaRepository;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;

import javax.transaction.Transactional;

import javax.transaction.Transactional;

@Service
public class PortariaService extends GenericService<Portaria, Long, PortariaDTO> {

	public PortariaService(PortariaRepository repository, EntityMapper<PortariaDTO, Portaria> mapper) {
		super(repository, mapper);
	}

	@Transactional
	public PortariaDTO salvar(PortariaDTO portariaDTO) {
		return this.mapper.toDto(save(this.mapper.toEntity(portariaDTO)));
	}

	public PortariaService(PortariaRepository repository, PortariaMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public Portaria atualizar(Long id, Portaria portaria) {
		var existingPortaria = findById(id);
		existingPortaria.setNumero(portaria.getNumero());
		existingPortaria.setDataPortaria(portaria.getDataPortaria());
		existingPortaria.setDescricao(portaria.getDescricao());
		return save(existingPortaria);
	}

}
