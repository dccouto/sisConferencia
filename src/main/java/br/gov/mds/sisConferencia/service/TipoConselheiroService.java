package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.repository.TipoConselheiroRepository;
import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoConselheiroMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoConselheiroService extends GenericService<TipoConselheiro, Long, TipoConselheiroDTO> {

	public TipoConselheiroService(TipoConselheiroRepository repository, TipoConselheiroMapper mapper) {
		super(repository, mapper);
	}
	public TipoConselheiroDTO atualizar(Long id, TipoConselheiroDTO tipoConselheiroAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(tipoConselheiroAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}
