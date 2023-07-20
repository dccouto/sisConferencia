package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoEndereco;
import br.gov.mds.sisConferencia.service.dto.TipoEnderecoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoEnderecoMapper implements EntityMapper<TipoEnderecoDTO, TipoEndereco>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoEnderecoMapper.mapper = mapper;
    }

    @Override
    public TipoEndereco toEntity(TipoEnderecoDTO tipoEnderecoDTO) {
        return mapper.map(tipoEnderecoDTO, TipoEndereco.class);
    }

    @Override
    public TipoEnderecoDTO toDto(TipoEndereco tipoEndereco) {
        return mapper.map(tipoEndereco, TipoEnderecoDTO.class);
    }

    @Override
    public List<TipoEndereco> toEntity(List<TipoEnderecoDTO> tipoEnderecoDTOList) {
        return tipoEnderecoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoEnderecoDTO> toDto(List<TipoEndereco> tipoEnderecoList) {
        return tipoEnderecoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}