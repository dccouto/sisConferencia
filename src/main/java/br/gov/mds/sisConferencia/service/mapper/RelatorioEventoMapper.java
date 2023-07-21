package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.RelatorioEvento;
import br.gov.mds.sisConferencia.service.dto.RelatorioEventoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class RelatorioEventoMapper implements EntityMapper<RelatorioEventoDTO, RelatorioEvento>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        RelatorioEventoMapper.mapper = mapper;
    }

    @Override
    public RelatorioEvento toEntity(RelatorioEventoDTO relatorioEventoDTO) {
        return mapper.map(relatorioEventoDTO, RelatorioEvento.class);
    }

    @Override
    public RelatorioEventoDTO toDto(RelatorioEvento relatorioEvento) {
        return mapper.map(relatorioEvento, RelatorioEventoDTO.class);
    }

    @Override
    public List<RelatorioEvento> toEntity(List<RelatorioEventoDTO> relatorioEventoDTOList) {
        return relatorioEventoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<RelatorioEventoDTO> toDto(List<RelatorioEvento> relatorioEventoList) {
        return relatorioEventoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
