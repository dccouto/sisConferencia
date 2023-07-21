package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoParticipacaoCeas;
import br.gov.mds.sisConferencia.service.dto.TipoParticipacaoCeasDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoParticipacaoCeasMapper implements EntityMapper<TipoParticipacaoCeasDTO, TipoParticipacaoCeas>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoParticipacaoCeasMapper.mapper = mapper;
    }

    @Override
    public TipoParticipacaoCeas toEntity(TipoParticipacaoCeasDTO tipoParticipacaoCeasDTO) {
        return mapper.map(tipoParticipacaoCeasDTO, TipoParticipacaoCeas.class);
    }

    @Override
    public TipoParticipacaoCeasDTO toDto(TipoParticipacaoCeas tipoParticipacaoCeas) {
        return mapper.map(tipoParticipacaoCeas, TipoParticipacaoCeasDTO.class);
    }

    @Override
    public List<TipoParticipacaoCeas> toEntity(List<TipoParticipacaoCeasDTO> tipoParticipacaoCeasDTOList) {
        return tipoParticipacaoCeasDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoParticipacaoCeasDTO> toDto(List<TipoParticipacaoCeas> tipoParticipacaoCeasList) {
        return tipoParticipacaoCeasList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
