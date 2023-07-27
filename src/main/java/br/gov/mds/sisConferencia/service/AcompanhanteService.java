package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.repository.AcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
import br.gov.mds.sisConferencia.service.mapper.AcompanhanteMapper;
import org.springframework.stereotype.Service;

@Service
public class AcompanhanteService extends GenericService<Acompanhante, Long, AcompanhanteDTO> {


	public AcompanhanteService(AcompanhanteRepository repository, AcompanhanteMapper mapper) {
		super(repository, mapper);
	}

	public AcompanhanteDTO atualizar(Long id, AcompanhanteDTO acompanhanteAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(acompanhanteAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}
}
