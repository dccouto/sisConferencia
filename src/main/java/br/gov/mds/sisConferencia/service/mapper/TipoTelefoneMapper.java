package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoTelefone;
import br.gov.mds.sisConferencia.service.dto.TipoTelefoneDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoTelefoneMapper implements EntityMapper<TipoTelefoneDTO, TipoTelefone>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoTelefoneMapper.mapper = mapper;
    }

    @Override
    public TipoTelefone toEntity(TipoTelefoneDTO tipoTelefoneDTO) {
        return mapper.map(tipoTelefoneDTO, TipoTelefone.class);
    }

    @Override
    public TipoTelefoneDTO toDto(TipoTelefone tipoTelefone) {
        return mapper.map(tipoTelefone, TipoTelefoneDTO.class);
    }

    @Override
    public List<TipoTelefone> toEntity(List<TipoTelefoneDTO> tipoTelefoneDTOList) {
        return tipoTelefoneDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoTelefoneDTO> toDto(List<TipoTelefone> tipoTelefoneList) {
        return tipoTelefoneList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
