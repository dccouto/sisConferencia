package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.ParticipacaoCeas;
import br.gov.mds.sisConferencia.service.dto.ParticipacaoCeasDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class ParticipacaoCeasMapper implements EntityMapper<ParticipacaoCeasDTO, ParticipacaoCeas>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        ParticipacaoCeasMapper.mapper = mapper;
    }

    @Override
    public ParticipacaoCeas toEntity(ParticipacaoCeasDTO participacaoCeasDTO) {
        return mapper.map(participacaoCeasDTO, ParticipacaoCeas.class);
    }

    @Override
    public ParticipacaoCeasDTO toDto(ParticipacaoCeas participacaoCeas) {
        return mapper.map(participacaoCeas, ParticipacaoCeasDTO.class);
    }

    @Override
    public List<ParticipacaoCeas> toEntity(List<ParticipacaoCeasDTO> participacaoCeasDTOList) {
        return participacaoCeasDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ParticipacaoCeasDTO> toDto(List<ParticipacaoCeas> participacaoCeasList) {
        return participacaoCeasList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}