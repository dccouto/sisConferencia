package br.gov.mds.sisConferencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioService {

	private final UsuarioRepository usuarioRepository;

	public List<Usuario> listarTodos() {
		return usuarioRepository.findAll();
	}

	public Optional<Usuario> buscarPorId(Long id) {
		return usuarioRepository.findById(id);
	}

	public Usuario salvar(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	public void excluir(Long id) {
		usuarioRepository.deleteById(id);
	}
}
