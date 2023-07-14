package br.gov.mds.sisConferencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.repository.PerfilRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PerfilService {
	
	private final PerfilRepository perfilRepository;

	public List<Perfil> listarTodos() {
		return perfilRepository.findAll();
	}

	public Optional<Perfil> buscarPorId(Long id) {
		return perfilRepository.findById(id);
	}

	public Perfil salvar(Perfil perfil) {
		return perfilRepository.save(perfil);
	}

	public void excluir(Long id) {
		perfilRepository.deleteById(id);
	}

}
