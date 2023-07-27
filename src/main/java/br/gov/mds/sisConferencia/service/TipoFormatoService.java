package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.TipoFormato;
import br.gov.mds.sisConferencia.repository.TipoFormatoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoFormatoDTO;
import org.springframework.stereotype.Service;

@Service
public class TipoFormatoService  extends GenericService<TipoFormato, Long, TipoFormatoDTO> {



	public TipoFormatoService(TipoFormatoRepository repository,
			EntityMapper<TipoFormatoDTO, TipoFormato> mapper) {
		super(repository, mapper);
	}

	public TipoFormatoDTO atualizar(Long id, TipoFormatoDTO tipoFormatoAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(tipoFormatoAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}
