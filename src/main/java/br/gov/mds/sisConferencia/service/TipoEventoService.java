package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.repository.TipoEventoRepository;

@Service
public class TipoEventoService extends GenericService<TipoEvento , Long> {

	public TipoEventoService(TipoEventoRepository repository) {
		super(repository);
	}


	public TipoEvento atualizar(Long id, TipoEvento tipoEvento) {
		TipoEvento existingTipoEvento = findById(id);
		existingTipoEvento.setDescricao(tipoEvento.getDescricao());
		return repository.save(existingTipoEvento);

	}
}