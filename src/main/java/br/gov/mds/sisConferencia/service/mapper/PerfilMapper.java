package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.service.dto.PerfilDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class PerfilMapper implements EntityMapper<PerfilDTO, Perfil>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        PerfilMapper.mapper = mapper;
    }

    @Override
    public Perfil toEntity(PerfilDTO perfilDTO) {
        return mapper.map(perfilDTO, Perfil.class);
    }

    @Override
    public PerfilDTO toDto(Perfil perfil) {
        return mapper.map(perfil, PerfilDTO.class);
    }

    @Override
    public List<Perfil> toEntity(List<PerfilDTO> perfilDTOList) {
        return perfilDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PerfilDTO> toDto(List<Perfil> perfilList) {
        return perfilList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
