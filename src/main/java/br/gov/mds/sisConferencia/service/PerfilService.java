package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.repository.PerfilRepository;
import br.gov.mds.sisConferencia.service.dto.PerfilDTO;

@Service
public class PerfilService extends GenericService<Perfil, Long, PerfilDTO> {

	public PerfilService(PerfilRepository repository, EntityMapper<PerfilDTO, Perfil> mapper) {
		super(repository, mapper);
	}

	public Perfil atualizar(Long id, Perfil perfil) {

		Perfil existingPerfil = findById(id);
		existingPerfil.setDescricao(perfil.getDescricao());
		return save(existingPerfil);

	}

}
