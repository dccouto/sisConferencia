package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import br.gov.mds.sisConferencia.service.mapper.TipoEventoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.repository.TipoEventoRepository;

import javax.transaction.Transactional;

@Service
public class TipoEventoService extends GenericService<TipoEvento , Long, TipoEventoDTO> {

	@Autowired
	EntityMapper<TipoEventoDTO, TipoEvento> entityMapper;

	@Transactional
	public TipoEventoDTO salvar(TipoEventoDTO tipoEventoDTO) {
		return this.entityMapper.toDto(save(this.entityMapper.toEntity(tipoEventoDTO)));
	}

	public TipoEventoService(TipoEventoRepository repository, TipoEventoMapper mapper) {
		super(repository, mapper);
	}

	@Transactional
	public TipoEvento atualizar(Long id, TipoEvento tipoEvento) {
		TipoEvento existingTipoEvento = findById(id);
		existingTipoEvento.setDescricao(tipoEvento.getDescricao());
		return save(existingTipoEvento);

	}
}