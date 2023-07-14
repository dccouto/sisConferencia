package br.gov.mds.sisConferencia.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.repository.OrgaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrgaoService {

	private final OrgaoRepository orgaoRepository;

	public List<Orgao> listarTodos() {
		return orgaoRepository.findAll();
	}

	public Optional<Orgao> buscarPorId(Long id) {
		return orgaoRepository.findById(id);
	}

	public Orgao salvar(Orgao orgao) {
		return orgaoRepository.save(orgao);
	}

	public void excluir(Long id) {
		orgaoRepository.deleteById(id);
	}
}