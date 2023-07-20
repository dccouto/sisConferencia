package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class PortariaMapper implements EntityMapper<PortariaDTO, Portaria>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        PortariaMapper.mapper = mapper;
    }

    @Override
    public Portaria toEntity(PortariaDTO portariaDTO) {
        return mapper.map(portariaDTO, Portaria.class);
    }

    @Override
    public PortariaDTO toDto(Portaria portaria) {
        return mapper.map(portaria, PortariaDTO.class);
    }

    @Override
    public List<Portaria> toEntity(List<PortariaDTO> portariaDTOList) {
        return portariaDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PortariaDTO> toDto(List<Portaria> portariaList) {
        return portariaList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}