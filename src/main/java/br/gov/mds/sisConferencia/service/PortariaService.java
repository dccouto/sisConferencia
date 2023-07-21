package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.repository.PortariaRepository;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;

@Service
public class PortariaService extends GenericService<Portaria, Long, PortariaDTO> {

	public PortariaService(PortariaRepository repository, EntityMapper<PortariaDTO, Portaria> mapper) {
		super(repository, mapper);
	}

	public PortariaDTO salvar(PortariaDTO portariaDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(portariaDTO)));
	}


	public Portaria atualizar(Long id, Portaria portaria) {
		var existingPortaria = findById(id);
		existingPortaria.setNumero(portaria.getNumero());
		existingPortaria.setDataPortaria(portaria.getDataPortaria());
		existingPortaria.setDescricao(portaria.getDescricao());
		return save(existingPortaria);

	}

}
