package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.AcompanhanteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.repository.AcompanhanteRepository;

import javax.transaction.Transactional;

@Service
public class AcompanhanteService extends GenericService<Acompanhante, Long, AcompanhanteDTO> {

	@Autowired
	EntityMapper<AcompanhanteDTO, Acompanhante> entityMapper;

	@Transactional
	public AcompanhanteDTO salvar(AcompanhanteDTO acompanhanteDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(acompanhanteDTO)));
	}

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
