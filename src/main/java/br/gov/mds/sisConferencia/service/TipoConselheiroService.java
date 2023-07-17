package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.repository.TipoConselheiroRepository;

@Service
public class TipoConselheiroService extends GenericService<TipoConselheiro, Long> {


	public TipoConselheiroService(TipoConselheiroRepository repository) {
		super(repository);
	}
	
	public TipoConselheiro atualizar(Long id, TipoConselheiro tipoConselheiroAtualizado) {
		TipoConselheiro tipoConselheiro = findById(id);
		tipoConselheiro.setDescricao(tipoConselheiroAtualizado.getDescricao());
		return save(tipoConselheiro);
		
	}


}
