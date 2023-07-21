package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Ementa;
import br.gov.mds.sisConferencia.service.dto.EmentaDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class EmentaMapper implements EntityMapper<EmentaDTO, Ementa>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        EmentaMapper.mapper = mapper;
    }

    @Override
    public Ementa toEntity(EmentaDTO ementaDTO) {
        return mapper.map(ementaDTO, Ementa.class);
    }

    @Override
    public EmentaDTO toDto(Ementa ementa) {
        return mapper.map(ementa, EmentaDTO.class);
    }

    @Override
    public List<Ementa> toEntity(List<EmentaDTO> ementaDTOList) {
        return ementaDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmentaDTO> toDto(List<Ementa> ementaList) {
        return ementaList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}