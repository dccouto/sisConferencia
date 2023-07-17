package br.gov.mds.sisConferencia.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Orgao;

@Service
public class OrgaoService extends GenericService<Orgao , Long> {

	public OrgaoService(JpaRepository<Orgao, Long> repository) {
		super(repository);
	}
	
	public Orgao atualizar(Long id, Orgao orgaoAtualizado) {
		Orgao orgao = findById(id);
		
		orgao.setNome(orgaoAtualizado.getNome());
		orgao.setAreaAtuacao(orgaoAtualizado.getAreaAtuacao());
		orgao.setCargoAtuante(orgaoAtualizado.getCargoAtuante());
		orgao.setEmail(orgaoAtualizado.getEmail());
		orgao.setIsConselheiro(orgaoAtualizado.getIsConselheiro());
		orgao.setEndereco(orgaoAtualizado.getEndereco());
		orgao.setTelefone(orgaoAtualizado.getTelefone());
		orgao.setTipoRepresentacao(orgaoAtualizado.getTipoRepresentacao());
		orgao.setSeguimento(orgaoAtualizado.getSeguimento());
		orgao.setAmbito(orgaoAtualizado.getAmbito());
		orgao.setConselho(orgaoAtualizado.getConselho());
		return save(orgao);

	}

}