package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.repository.UsuarioRepository;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;
import br.gov.mds.sisConferencia.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UsuarioService extends GenericService<Usuario , Long, UsuarioDTO> {

	public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		Usuario existingUsuario = findById(id);
		existingUsuario.setIdPessoa(usuarioAtualizado.getIdPessoa());
		existingUsuario.setPerfil(usuarioAtualizado.getPerfil());
		return save(existingUsuario);
	}

}
