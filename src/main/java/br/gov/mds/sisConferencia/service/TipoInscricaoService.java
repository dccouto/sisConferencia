package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.repository.TipoInscricaoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;

@Service
public class TipoInscricaoService extends GenericService<TipoInscricao , Long, TipoInscricaoDTO> {

	public TipoInscricaoService(TipoInscricaoRepository repository,
			EntityMapper<TipoInscricaoDTO, TipoInscricao> mapper) {
		super(repository, mapper);
	}

	public TipoInscricaoDTO salvar(TipoInscricaoDTO tipoInscricaoDTO) {
		return this.mapper.toDto(save(this.mapper.toEntity(tipoInscricaoDTO)));
	}

	public TipoInscricao atualizar(Long id, TipoInscricao tipoInscricaoAtualizado) {
		TipoInscricao tipoInscricao = findById(id);
		tipoInscricao.setDescricao(tipoInscricaoAtualizado.getDescricao());
		return save(tipoInscricao);
		
	}
}
