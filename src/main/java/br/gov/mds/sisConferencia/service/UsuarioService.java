package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.repository.UsuarioRepository;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;

@Service
public class UsuarioService extends GenericService<Usuario , Long, UsuarioDTO> {


	
	public UsuarioService(UsuarioRepository repository, EntityMapper<UsuarioDTO, Usuario> mapper) {
		super(repository, mapper);
	}

	public Usuario atualizar(Long id, Usuario usuarioAtualizado) {
		Usuario existingUsuario = findById(id);
		existingUsuario.setIdPessoa(usuarioAtualizado.getIdPessoa());
		existingUsuario.setPerfil(usuarioAtualizado.getPerfil());
		return save(existingUsuario);

	}

}
