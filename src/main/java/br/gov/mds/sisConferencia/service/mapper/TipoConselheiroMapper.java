package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoConselheiroMapper implements EntityMapper<TipoConselheiroDTO, TipoConselheiro>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoConselheiroMapper.mapper = mapper;
    }

    @Override
    public TipoConselheiro toEntity(TipoConselheiroDTO tipoConselheiroDTO) {
        return mapper.map(tipoConselheiroDTO, TipoConselheiro.class);
    }

    @Override
    public TipoConselheiroDTO toDto(TipoConselheiro tipoConselheiro) {
        return mapper.map(tipoConselheiro, TipoConselheiroDTO.class);
    }

    @Override
    public List<TipoConselheiro> toEntity(List<TipoConselheiroDTO> tipoConselheiroDTOList) {
        return tipoConselheiroDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoConselheiroDTO> toDto(List<TipoConselheiro> tipoConselheiroList) {
        return tipoConselheiroList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
