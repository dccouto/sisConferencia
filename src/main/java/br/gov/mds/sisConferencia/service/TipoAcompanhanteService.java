package br.gov.mds.sisConferencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.repository.TipoAcompanhanteRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TipoAcompanhanteService {
	
	private final TipoAcompanhanteRepository tipoAcompanhanteRepository;

	public List<TipoAcompanhante> listarTodos() {
		return tipoAcompanhanteRepository.findAll();
	}

	public Optional<TipoAcompanhante> buscarPorId(Long id) {
		return tipoAcompanhanteRepository.findById(id);
	}

	public TipoAcompanhante salvar(TipoAcompanhante tipoAcompanhante) {
		return tipoAcompanhanteRepository.save(tipoAcompanhante);
	}

	public void excluir(Long id) {
		tipoAcompanhanteRepository.deleteById(id);
	}
}
