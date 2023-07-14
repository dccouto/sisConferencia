package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.repository.TipoInscricaoRepository;

@Service
public class TipoInscricaoService extends GenericService<TipoInscricao , Long> {

	public TipoInscricaoService(TipoInscricaoRepository repository) {
		super(repository);
	}


	public TipoInscricao atualizar(Long id, TipoInscricao tipoInscricaoAtualizado) {
		TipoInscricao tipoInscricao = findById(id);
		tipoInscricao.setDescricao(tipoInscricaoAtualizado.getDescricao());
		return save(tipoInscricao);
		
	}
}
