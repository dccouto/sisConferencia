package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.InformacaoEvento;
import br.gov.mds.sisConferencia.service.dto.InformacaoEventoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class InformacaoEventoMapper implements EntityMapper<InformacaoEventoDTO, InformacaoEvento>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        InformacaoEventoMapper.mapper = mapper;
    }

    @Override
    public InformacaoEvento toEntity(InformacaoEventoDTO informacaoEventoDTO) {
        return mapper.map(informacaoEventoDTO, InformacaoEvento.class);
    }

    @Override
    public InformacaoEventoDTO toDto(InformacaoEvento informacaoEvento) {
        return mapper.map(informacaoEvento, InformacaoEventoDTO.class);
    }

    @Override
    public List<InformacaoEvento> toEntity(List<InformacaoEventoDTO> informacaoEventoDTOList) {
        return informacaoEventoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<InformacaoEventoDTO> toDto(List<InformacaoEvento> informacaoEventoList) {
        return informacaoEventoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
