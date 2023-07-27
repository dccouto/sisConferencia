package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.repository.PortariaRepository;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;
import br.gov.mds.sisConferencia.service.mapper.PortariaMapper;
import org.springframework.stereotype.Service;

@Service
public class PortariaService extends GenericService<Portaria, Long, PortariaDTO> {

	public PortariaService(PortariaRepository repository, PortariaMapper mapper) {
		super(repository, mapper);
	}

	public PortariaDTO atualizar(Long id, PortariaDTO portariaAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(portariaAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}
