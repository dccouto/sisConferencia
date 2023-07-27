package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.repository.TipoAcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoAcompanhanteMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoAcompanhanteService extends GenericService<TipoAcompanhante, Long, TipoAcompanhanteDTO> {

	public TipoAcompanhanteService(TipoAcompanhanteRepository repository, TipoAcompanhanteMapper mapper) {
		super(repository, mapper);
	}

	public TipoAcompanhanteDTO atualizar(Long id, TipoAcompanhanteDTO tipoAcompanhanteAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(tipoAcompanhanteAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}


}
