package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.repository.UsuarioRepository;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;
import br.gov.mds.sisConferencia.service.mapper.UsuarioMapper;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService extends GenericService<Usuario , Long, UsuarioDTO> {

	public UsuarioService(UsuarioRepository repository, UsuarioMapper mapper) {
		super(repository, mapper);
	}

	public UsuarioDTO atualizar(Long id, UsuarioDTO usuarioAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(usuarioAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}
