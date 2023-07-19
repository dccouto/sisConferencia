package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class AmbitoMapper implements EntityMapper<AmbitoDTO, Ambito>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        AmbitoMapper.mapper = mapper;
    }

    @Override
    public Ambito toEntity(AmbitoDTO ambitoDTO) {
        return mapper.map(ambitoDTO, Ambito.class);
    }

    @Override
    public AmbitoDTO toDto(Ambito ambito) {
        return mapper.map(ambito, AmbitoDTO.class);
    }

    @Override
    public List<Ambito> toEntity(List<AmbitoDTO> ambitoDTOList) {
        return ambitoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<AmbitoDTO> toDto(List<Ambito> ambitoList) {
        return ambitoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
