package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class OrgaoMapper implements EntityMapper<OrgaoDTO, Orgao>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        OrgaoMapper.mapper = mapper;
    }

    @Override
    public Orgao toEntity(OrgaoDTO orgaoDTO) {
        return mapper.map(orgaoDTO, Orgao.class);
    }

    @Override
    public OrgaoDTO toDto(Orgao orgao) {
        return mapper.map(orgao, OrgaoDTO.class);
    }

    @Override
    public List<Orgao> toEntity(List<OrgaoDTO> orgaoDTOList) {
        return orgaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<OrgaoDTO> toDto(List<Orgao> orgaoList) {
        return orgaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
