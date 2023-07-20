package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Telefone;
import br.gov.mds.sisConferencia.service.dto.TelefoneDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TelefoneMapper implements EntityMapper<TelefoneDTO, Telefone>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TelefoneMapper.mapper = mapper;
    }

    @Override
    public Telefone toEntity(TelefoneDTO telefoneDTO) {
        return mapper.map(telefoneDTO, Telefone.class);
    }

    @Override
    public TelefoneDTO toDto(Telefone telefone) {
        return mapper.map(telefone, TelefoneDTO.class);
    }

    @Override
    public List<Telefone> toEntity(List<TelefoneDTO> telefoneDTOList) {
        return telefoneDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TelefoneDTO> toDto(List<Telefone> telefoneList) {
        return telefoneList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
