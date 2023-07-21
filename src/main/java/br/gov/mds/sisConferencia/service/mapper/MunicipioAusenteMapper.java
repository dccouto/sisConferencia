package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.MunicipioAusente;
import br.gov.mds.sisConferencia.service.dto.MunicipioAusenteDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class MunicipioAusenteMapper implements EntityMapper<MunicipioAusenteDTO, MunicipioAusente>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        MunicipioAusenteMapper.mapper = mapper;
    }

    @Override
    public MunicipioAusente toEntity(MunicipioAusenteDTO municipioAusenteDTO) {
        return mapper.map(municipioAusenteDTO, MunicipioAusente.class);
    }

    @Override
    public MunicipioAusenteDTO toDto(MunicipioAusente municipioAusente) {
        return mapper.map(municipioAusente, MunicipioAusenteDTO.class);
    }

    @Override
    public List<MunicipioAusente> toEntity(List<MunicipioAusenteDTO> municipioAusenteDTOList) {
        return municipioAusenteDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MunicipioAusenteDTO> toDto(List<MunicipioAusente> municipioAusenteList) {
        return municipioAusenteList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}