package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Endereco;
import br.gov.mds.sisConferencia.service.dto.EnderecoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class EnderecoMapper implements EntityMapper<EnderecoDTO, Endereco>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        EnderecoMapper.mapper = mapper;
    }

    @Override
    public Endereco toEntity(EnderecoDTO enderecoDTO) {
        return mapper.map(enderecoDTO, Endereco.class);
    }

    @Override
    public EnderecoDTO toDto(Endereco endereco) {
        return mapper.map(endereco, EnderecoDTO.class);
    }

    @Override
    public List<Endereco> toEntity(List<EnderecoDTO> enderecoDTOList) {
        return enderecoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<EnderecoDTO> toDto(List<Endereco> enderecoList) {
        return enderecoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
