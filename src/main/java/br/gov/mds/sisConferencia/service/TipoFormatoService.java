package br.gov.mds.sisConferencia.service;

import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoFormato;
import br.gov.mds.sisConferencia.repository.TipoFormatoRepository;
import br.gov.mds.sisConferencia.service.dto.TipoFormatoDTO;

@Service
public class TipoFormatoService  extends GenericService<TipoFormato, Long, TipoFormatoDTO> {



	public TipoFormatoService(TipoFormatoRepository repository,
			EntityMapper<TipoFormatoDTO, TipoFormato> mapper) {
		super(repository, mapper);
	}

	public TipoFormato atualizar(Long id, TipoFormato tipoFormato) {
		TipoFormato existingTipoFormato = findById(id);
		existingTipoFormato.setDescricao(tipoFormato.getDescricao());
		return save(existingTipoFormato);

	}

}
