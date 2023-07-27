package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.repository.AmbitoRepository;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import br.gov.mds.sisConferencia.service.mapper.AmbitoMapper;
import org.springframework.stereotype.Service;

@Service
public class AmbitoService extends GenericService<Ambito , Long, AmbitoDTO> {

	public AmbitoService(AmbitoRepository repository, AmbitoMapper mapper) {
		super(repository, mapper);
	}

	public AmbitoDTO atualizar(Long id, AmbitoDTO ambitoAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(ambitoAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}
}