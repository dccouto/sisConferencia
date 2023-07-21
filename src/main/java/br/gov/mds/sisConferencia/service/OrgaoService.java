package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;
import br.gov.mds.sisConferencia.service.mapper.OrgaoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;

import javax.transaction.Transactional;

@Service
public class OrgaoService extends GenericService<Orgao, Long, OrgaoDTO> {

	public OrgaoService(JpaRepository<Orgao, Long> repository, EntityMapper<OrgaoDTO, Orgao> mapper) {
		super(repository, mapper);
	}

	@Transactional
	public OrgaoDTO salvar(OrgaoDTO orgaoDTO) {
		return mapper.toDto(save(mapper.toEntity(orgaoDTO)));
	}

	public OrgaoService(JpaRepository<Orgao, Long> repository, OrgaoMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
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