package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class ArquivoMapper implements EntityMapper<ArquivoDTO, Arquivo> {

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        ArquivoMapper.mapper = mapper;
    }

    @Override
    public Arquivo toEntity(ArquivoDTO arquivoDTO) {
        return mapper.map(arquivoDTO, Arquivo.class);
    }

    @Override
    public ArquivoDTO toDto(Arquivo arquivo) {
        return mapper.map(arquivo, ArquivoDTO.class);
    }

    @Override
    public List<Arquivo> toEntity(List<ArquivoDTO> arquivoDTOList) {
        return arquivoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ArquivoDTO> toDto(List<Arquivo> arquivoList) {
        return arquivoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
