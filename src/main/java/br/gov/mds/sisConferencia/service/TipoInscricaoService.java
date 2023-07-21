package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.repository.TipoInscricaoRepository;

import javax.transaction.Transactional;

@Service
public class TipoInscricaoService extends GenericService<TipoInscricao , Long> {

	@Autowired
	EntityMapper<TipoInscricaoDTO, TipoInscricao> entityMapper;

	@Transactional
	public TipoInscricaoDTO salvar(TipoInscricaoDTO tipoInscricaoDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(tipoInscricaoDTO)));
	}

	public TipoInscricaoService(TipoInscricaoRepository repository) {
		super(repository);
	}

	@Transactional
	public TipoInscricao atualizar(Long id, TipoInscricao tipoInscricaoAtualizado) {
		TipoInscricao tipoInscricao = findById(id);
		tipoInscricao.setDescricao(tipoInscricaoAtualizado.getDescricao());
		return save(tipoInscricao);
		
	}
}
