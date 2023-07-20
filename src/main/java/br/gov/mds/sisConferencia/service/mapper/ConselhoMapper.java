package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Conselho;
import br.gov.mds.sisConferencia.service.dto.ConselhoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class ConselhoMapper implements EntityMapper<ConselhoDTO, Conselho>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        ConselhoMapper.mapper = mapper;
    }

    @Override
    public Conselho toEntity(ConselhoDTO conselhoDTO) {
        return mapper.map(conselhoDTO, Conselho.class);
    }

    @Override
    public ConselhoDTO toDto(Conselho conselho) {
        return mapper.map(conselho, ConselhoDTO.class);
    }

    @Override
    public List<Conselho> toEntity(List<ConselhoDTO> conselhoDTOList) {
        return conselhoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConselhoDTO> toDto(List<Conselho> conselhoList) {
        return conselhoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
