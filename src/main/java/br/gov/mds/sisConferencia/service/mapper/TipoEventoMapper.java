package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoEventoMapper implements EntityMapper<TipoEventoDTO, TipoEvento>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoEventoMapper.mapper = mapper;
    }

    @Override
    public TipoEvento toEntity(TipoEventoDTO tipoEventoDTO) {
        return mapper.map(tipoEventoDTO, TipoEvento.class);
    }

    @Override
    public TipoEventoDTO toDto(TipoEvento tipoEvento) {
        return mapper.map(tipoEvento, TipoEventoDTO.class);
    }

    @Override
    public List<TipoEvento> toEntity(List<TipoEventoDTO> tipoEventoDTOList) {
        return tipoEventoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoEventoDTO> toDto(List<TipoEvento> tipoEventoList) {
        return tipoEventoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
