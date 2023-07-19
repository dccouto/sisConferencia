package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.repository.EventoRepository;

@Service
public class EventoService extends GenericService<Evento, Long> {

	public EventoService(EventoRepository repository) {
		super(repository);
	}
	
	public Evento atualizar(Long id, Evento eventoAtualizado) {
		Evento existingEvento = findById(id);
		
		existingEvento.setNome(eventoAtualizado.getNome());
		existingEvento.setObjetivo(eventoAtualizado.getObjetivo());
		existingEvento.setTema(eventoAtualizado.getTema());
		existingEvento.setDataCadastro(eventoAtualizado.getDataCadastro());
		existingEvento.setDataInicial(eventoAtualizado.getDataInicial());
		existingEvento.setDataFinal(eventoAtualizado.getDataFinal());
		existingEvento.setAtivo(eventoAtualizado.getAtivo());
		existingEvento.setTipoEvento(eventoAtualizado.getTipoEvento());
		existingEvento.setTipoRegime(eventoAtualizado.getTipoRegime());
		existingEvento.setPortaria(eventoAtualizado.getPortaria());
		existingEvento.setEixos(eventoAtualizado.getEixos());
		existingEvento.setDocumentos(eventoAtualizado.getDocumentos());
		
		return save(existingEvento);

	}


}
