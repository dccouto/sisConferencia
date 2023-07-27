package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.repository.ArquivoRepository;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import org.springframework.stereotype.Service;

@Service
public class ArquivoService extends GenericService<Arquivo, Long, ArquivoDTO> {



	public ArquivoService(ArquivoRepository repository, EntityMapper<ArquivoDTO, Arquivo> mapper) {
		super(repository, mapper);
	}

	public ArquivoDTO atualizar(Long id, ArquivoDTO arquivoAtualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(arquivoAtualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}
	
}
