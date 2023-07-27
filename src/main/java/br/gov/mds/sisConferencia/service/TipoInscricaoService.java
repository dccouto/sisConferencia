package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.repository.TipoInscricaoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoInscricaoMapper;
import org.springframework.stereotype.Service;

@Service
public class TipoInscricaoService extends GenericService<TipoInscricao, Long, TipoInscricaoDTO> {

	public TipoInscricaoService(TipoInscricaoRepository repository, TipoInscricaoMapper mapper) {
		super(repository, mapper);
	}

	public TipoInscricaoDTO atualizar(Long id, TipoInscricaoDTO tipoInscricaoAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(tipoInscricaoAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}
}
