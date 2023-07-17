package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.repository.UsuarioRepository;

@Service
public class UsuarioService extends GenericService<Usuario , Long> {

	public UsuarioService(UsuarioRepository repository) {
		super(repository);
	}
	
	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		Usuario existingUsuario = findById(id);
		existingUsuario.setIdPessoa(usuarioAtualizado.getIdPessoa());
		existingUsuario.setPerfil(usuarioAtualizado.getPerfil());
		return save(existingUsuario);

	}

}
