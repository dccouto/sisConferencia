package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoAcompanhanteMapper implements EntityMapper<TipoAcompanhanteDTO, TipoAcompanhante>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoAcompanhanteMapper.mapper = mapper;
    }

    @Override
    public TipoAcompanhante toEntity(TipoAcompanhanteDTO tipoAcompanhanteDTO) {
        return mapper.map(tipoAcompanhanteDTO, TipoAcompanhante.class);
    }

    @Override
    public TipoAcompanhanteDTO toDto(TipoAcompanhante tipoAcompanhante) {
        return mapper.map(tipoAcompanhante, TipoAcompanhanteDTO.class);
    }

    @Override
    public List<TipoAcompanhante> toEntity(List<TipoAcompanhanteDTO> tipoAcompanhanteDTOList) {
        return tipoAcompanhanteDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoAcompanhanteDTO> toDto(List<TipoAcompanhante> tipoAcompanhanteList) {
        return tipoAcompanhanteList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
