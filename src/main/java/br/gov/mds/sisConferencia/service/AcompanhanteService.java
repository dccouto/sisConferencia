package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.repository.AcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
import br.gov.mds.sisConferencia.service.mapper.AcompanhanteMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AcompanhanteService extends GenericService<Acompanhante, Long, AcompanhanteDTO> {


	public AcompanhanteService(AcompanhanteRepository repository, AcompanhanteMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public Acompanhante atualizar(Long id, Acompanhante acompanhanteAtualizado) {
		Acompanhante existingAcompanhante = findById(id);

		existingAcompanhante.setNome(acompanhanteAtualizado.getNome());
		existingAcompanhante.setNomeCracha(acompanhanteAtualizado.getNomeCracha());
		existingAcompanhante.setRg(acompanhanteAtualizado.getRg());
		existingAcompanhante.setOrgaoExpedidor(acompanhanteAtualizado.getOrgaoExpedidor());
		existingAcompanhante.setCpf(acompanhanteAtualizado.getCpf());
		existingAcompanhante.setEmail(acompanhanteAtualizado.getEmail());
		existingAcompanhante.setSexo(acompanhanteAtualizado.getSexo());
		existingAcompanhante.setEndereco(acompanhanteAtualizado.getEndereco());
		existingAcompanhante.setTelefone(acompanhanteAtualizado.getTelefone());
		existingAcompanhante.setInformacaoComplementar(acompanhanteAtualizado.getInformacaoComplementar());
		existingAcompanhante.setTipoDeficiencia(acompanhanteAtualizado.getTipoDeficiencia());		
		return repository.save(existingAcompanhante);
	}

}
