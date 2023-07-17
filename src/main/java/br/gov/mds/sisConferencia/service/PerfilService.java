package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.repository.PerfilRepository;

@Service
public class PerfilService extends GenericService<Perfil , Long> {
	
	public PerfilService(PerfilRepository repository) {
		super(repository);
	}
	
	public Perfil atualizar(Long id, Perfil perfil) {
		Perfil existingPerfil = findById(id);
		existingPerfil.setDescricao(perfil.getDescricao());
		return save(existingPerfil);
		
	}

}
