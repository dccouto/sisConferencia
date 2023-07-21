package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.repository.AcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;

@Service
public class AcompanhanteService extends GenericService<Acompanhante, Long, AcompanhanteDTO> {

	public AcompanhanteService(AcompanhanteRepository repository, EntityMapper<AcompanhanteDTO, Acompanhante> mapper) {
		super(repository, mapper);
	}

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
