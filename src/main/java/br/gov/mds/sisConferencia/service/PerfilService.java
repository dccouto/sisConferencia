package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.repository.PerfilRepository;
import br.gov.mds.sisConferencia.service.dto.PerfilDTO;
import br.gov.mds.sisConferencia.service.mapper.PerfilMapper;
import org.springframework.stereotype.Service;

@Service
public class PerfilService extends GenericService<Perfil , Long, PerfilDTO> {

	public PerfilService(PerfilRepository repository, PerfilMapper mapper) {
		super(repository, mapper);
	}

	public PerfilDTO atualizar(Long id, PerfilDTO perfilAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(perfilAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}
