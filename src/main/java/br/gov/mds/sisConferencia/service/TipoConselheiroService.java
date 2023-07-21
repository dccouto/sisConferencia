package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.repository.TipoConselheiroRepository;
import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;

@Service
public class TipoConselheiroService extends GenericService<TipoConselheiro, Long, TipoConselheiroDTO> {
	
	public TipoConselheiroService(TipoConselheiroRepository repository,
			EntityMapper<TipoConselheiroDTO, TipoConselheiro> mapper) {
		super(repository, mapper);
	}

	public TipoConselheiro atualizar(Long id, TipoConselheiro tipoConselheiroAtualizado) {
		TipoConselheiro tipoConselheiro = findById(id);
		tipoConselheiro.setDescricao(tipoConselheiroAtualizado.getDescricao());
		return save(tipoConselheiro);
		
	}


}
