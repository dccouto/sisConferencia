package br.gov.mds.sisConferencia.service;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;
import br.gov.mds.sisConferencia.service.mapper.OrgaoMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class OrgaoService extends GenericService<Orgao , Long, OrgaoDTO> {


	public OrgaoService(JpaRepository<Orgao, Long> repository, OrgaoMapper mapper ) {
		super(repository, mapper);
	}

	public OrgaoDTO atualizar(Long id, OrgaoDTO Atualizado) {
			if (repository.existsById(id)) {
				return atualizar(mapper.toDto(mapper.toEntity(Atualizado)));
			} else {
				throw new SisConferenciaNotFoundException("Não encontrado.");
			}
	}

}