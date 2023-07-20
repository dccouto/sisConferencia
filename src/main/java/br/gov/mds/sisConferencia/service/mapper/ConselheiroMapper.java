package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Conselheiro;
import br.gov.mds.sisConferencia.service.dto.ConselheiroDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class ConselheiroMapper implements EntityMapper<ConselheiroDTO, Conselheiro> {

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        ConselheiroMapper.mapper = mapper;
    }

    @Override
    public Conselheiro toEntity(ConselheiroDTO conselheiroDTO) {
        return mapper.map(conselheiroDTO, Conselheiro.class);
    }

    @Override
    public ConselheiroDTO toDto(Conselheiro conselheiro) {
        return mapper.map(conselheiro, ConselheiroDTO.class);
    }

    @Override
    public List<Conselheiro> toEntity(List<ConselheiroDTO> conselheiroDTOList) {
        return conselheiroDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<ConselheiroDTO> toDto(List<Conselheiro> conselheiroList) {
        return conselheiroList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
