package br.gov.mds.sisConferencia.service;

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
		// TODO Auto-generated constructor stub
	}

	public TipoInscricao atualizar(Long id, TipoInscricao tipoInscricaoAtualizado) {
		TipoInscricao tipoInscricao = findById(id);
		tipoInscricao.setDescricao(tipoInscricaoAtualizado.getDescricao());
		return save(tipoInscricao);
		
	}
}
