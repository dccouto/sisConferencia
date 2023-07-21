package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.repository.ArquivoRepository;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;

@Service
public class ArquivoService extends GenericService<Arquivo, Long, ArquivoDTO> {



	public ArquivoService(ArquivoRepository repository, EntityMapper<ArquivoDTO, Arquivo> mapper) {
		super(repository, mapper);
	}

	public Arquivo atualizar(Long id, Arquivo arquivoAtualizado) {
		Arquivo existingArquivo = findById(id);
		existingArquivo.setByteArquivo(arquivoAtualizado.getByteArquivo());
		return save(existingArquivo);
	}
	
}
