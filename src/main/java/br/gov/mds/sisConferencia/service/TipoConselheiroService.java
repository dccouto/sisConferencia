package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.repository.TipoConselheiroRepository;
import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoConselheiroMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class TipoConselheiroService extends GenericService<TipoConselheiro, Long, TipoConselheiroDTO> {

	public TipoConselheiroService(TipoConselheiroRepository repository, TipoConselheiroMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public TipoConselheiro atualizar(Long id, TipoConselheiro tipoConselheiroAtualizado) {
		TipoConselheiro tipoConselheiro = findById(id);
		tipoConselheiro.setDescricao(tipoConselheiroAtualizado.getDescricao());
		return save(tipoConselheiro);
		
	}


}
