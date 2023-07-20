package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoRegime;
import br.gov.mds.sisConferencia.service.dto.TipoRegimeDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoRegimeMapper implements EntityMapper<TipoRegimeDTO, TipoRegime>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoRegimeMapper.mapper = mapper;
    }

    @Override
    public TipoRegime toEntity(TipoRegimeDTO tipoRegimeDTO) {
        return mapper.map(tipoRegimeDTO, TipoRegime.class);
    }

    @Override
    public TipoRegimeDTO toDto(TipoRegime tipoRegime) {
        return mapper.map(tipoRegime, TipoRegimeDTO.class);
    }

    @Override
    public List<TipoRegime> toEntity(List<TipoRegimeDTO> tipoRegimeDTOList) {
        return tipoRegimeDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoRegimeDTO> toDto(List<TipoRegime> tipoRegimeList) {
        return tipoRegimeList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
