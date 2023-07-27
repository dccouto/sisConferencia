package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.repository.TipoEventoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoEventoMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoEventoService extends GenericService<TipoEvento , Long, TipoEventoDTO> {

	public TipoEventoService(TipoEventoRepository repository, TipoEventoMapper mapper) {
		super(repository, mapper);
	}

	public TipoEventoDTO atualizar(Long id, TipoEventoDTO tipoEventoAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(tipoEventoAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}
}