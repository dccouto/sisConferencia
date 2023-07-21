package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;
import br.gov.mds.sisConferencia.service.mapper.UsuarioMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.repository.UsuarioRepository;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;

import javax.transaction.Transactional;

@Service
public class UsuarioService extends GenericService<Usuario, Long, UsuarioDTO> {

	
	@Autowired
	EntityMapper<UsuarioDTO, Usuario> entityMapper;

	@Transactional
	public UsuarioDTO salvar(UsuarioDTO usuarioDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(usuarioDTO)));
	}

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
