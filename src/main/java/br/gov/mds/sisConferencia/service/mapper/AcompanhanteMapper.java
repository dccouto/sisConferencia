package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class AcompanhanteMapper implements EntityMapper<AcompanhanteDTO, Acompanhante>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        AcompanhanteMapper.mapper = mapper;
    }

    @Override
    public Acompanhante toEntity(AcompanhanteDTO acompanhanteDTO) {
        return mapper.map(acompanhanteDTO, Acompanhante.class);
    }

    @Override
    public AcompanhanteDTO toDto(Acompanhante acompanhante) {
        return mapper.map(acompanhante, AcompanhanteDTO.class);
    }

    @Override
    public List<Acompanhante> toEntity(List<AcompanhanteDTO> acompanhanteDTOList) {
        return acompanhanteDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AcompanhanteDTO> toDto(List<Acompanhante> acompanhanteList) {
        return acompanhanteList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
