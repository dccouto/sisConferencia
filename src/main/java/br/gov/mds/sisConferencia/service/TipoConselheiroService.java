package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoConselheiroMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.repository.TipoConselheiroRepository;

import javax.transaction.Transactional;

@Service
public class TipoConselheiroService extends GenericService<TipoConselheiro, Long, TipoConselheiroDTO> {


	@Autowired
	EntityMapper<TipoConselheiroDTO, TipoConselheiro> entityMapper;

	@Transactional
	public TipoConselheiroDTO salvar(TipoConselheiroDTO tipoConselheiroDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(tipoConselheiroDTO)));
	}

	public TipoConselheiroService(TipoConselheiroRepository repository, TipoConselheiroMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public TipoConselheiro atualizar(Long id, TipoConselheiro tipoConselheiroAtualizado) {
		TipoConselheiro tipoConselheiro = findById(id);
		tipoConselheiro.setDescricao(tipoConselheiroAtualizado.getDescricao());
		return save(tipoConselheiro);
		
	}


}
