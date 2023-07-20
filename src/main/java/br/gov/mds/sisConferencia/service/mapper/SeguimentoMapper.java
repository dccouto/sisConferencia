package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Seguimento;
import br.gov.mds.sisConferencia.service.dto.SeguimentoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class SeguimentoMapper implements EntityMapper<SeguimentoDTO, Seguimento>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        SeguimentoMapper.mapper = mapper;
    }

    @Override
    public Seguimento toEntity(SeguimentoDTO seguimentoDTO) {
        return mapper.map(seguimentoDTO, Seguimento.class);
    }

    @Override
    public SeguimentoDTO toDto(Seguimento seguimento) {
        return mapper.map(seguimento, SeguimentoDTO.class);
    }

    @Override
    public List<Seguimento> toEntity(List<SeguimentoDTO> seguimentoDTOList) {
        return seguimentoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SeguimentoDTO> toDto(List<Seguimento> seguimentoList) {
        return seguimentoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}