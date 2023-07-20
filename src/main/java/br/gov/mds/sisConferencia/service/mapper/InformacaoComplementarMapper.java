package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.InformacaoComplementar;
import br.gov.mds.sisConferencia.service.dto.InformacaoComplementarDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class InformacaoComplementarMapper implements EntityMapper<InformacaoComplementarDTO, InformacaoComplementar>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        InformacaoComplementarMapper.mapper = mapper;
    }

    @Override
    public InformacaoComplementar toEntity(InformacaoComplementarDTO informacaoComplementarDTO) {
        return mapper.map(informacaoComplementarDTO, InformacaoComplementar.class);
    }

    @Override
    public InformacaoComplementarDTO toDto(InformacaoComplementar informacaoComplementar) {
        return mapper.map(informacaoComplementar, InformacaoComplementarDTO.class);
    }

    @Override
    public List<InformacaoComplementar> toEntity(List<InformacaoComplementarDTO> informacaoComplementarDTOList) {
        return informacaoComplementarDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<InformacaoComplementarDTO> toDto(List<InformacaoComplementar> informacaoComplementarList) {
        return informacaoComplementarList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
