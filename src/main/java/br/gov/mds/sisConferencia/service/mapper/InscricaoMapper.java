package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Inscricao;
import br.gov.mds.sisConferencia.service.dto.InscricaoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class InscricaoMapper implements EntityMapper<InscricaoDTO, Inscricao>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        InscricaoMapper.mapper = mapper;
    }

    @Override
    public Inscricao toEntity(InscricaoDTO inscricaoDTO) {
        return mapper.map(inscricaoDTO, Inscricao.class);
    }

    @Override
    public InscricaoDTO toDto(Inscricao inscricao) {
        return mapper.map(inscricao, InscricaoDTO.class);
    }

    @Override
    public List<Inscricao> toEntity(List<InscricaoDTO> inscricaoDTOList) {
        return inscricaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<InscricaoDTO> toDto(List<Inscricao> inscricaoList) {
        return inscricaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
