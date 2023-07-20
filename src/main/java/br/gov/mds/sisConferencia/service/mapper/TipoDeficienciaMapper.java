package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoDeficiencia;
import br.gov.mds.sisConferencia.service.dto.TipoDeficienciaDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoDeficienciaMapper implements EntityMapper<TipoDeficienciaDTO, TipoDeficiencia>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoDeficienciaMapper.mapper = mapper;
    }

    @Override
    public TipoDeficiencia toEntity(TipoDeficienciaDTO tipoDeficienciaDTO) {
        return mapper.map(tipoDeficienciaDTO, TipoDeficiencia.class);
    }

    @Override
    public TipoDeficienciaDTO toDto(TipoDeficiencia tipoDeficiencia) {
        return mapper.map(tipoDeficiencia, TipoDeficienciaDTO.class);
    }

    @Override
    public List<TipoDeficiencia> toEntity(List<TipoDeficienciaDTO> tipoDeficienciaDTOList) {
        return tipoDeficienciaDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoDeficienciaDTO> toDto(List<TipoDeficiencia> tipoDeficienciaList) {
        return tipoDeficienciaList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
