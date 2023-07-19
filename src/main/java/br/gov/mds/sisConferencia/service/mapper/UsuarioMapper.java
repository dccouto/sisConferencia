package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class UsuarioMapper implements EntityMapper<UsuarioDTO, Usuario> {

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        UsuarioMapper.mapper = mapper;
    }

    @Override
    public Usuario toEntity(UsuarioDTO usuarioDTO) {
        return mapper.map(usuarioDTO, Usuario.class);
    }

    @Override
    public UsuarioDTO toDto(Usuario usuario) {
        return mapper.map(usuario, UsuarioDTO.class);
    }

    @Override
    public List<Usuario> toEntity(List<UsuarioDTO> usuarioDTOList) {
        return usuarioDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<UsuarioDTO> toDto(List<Usuario> usuarioList) {
        return usuarioList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
