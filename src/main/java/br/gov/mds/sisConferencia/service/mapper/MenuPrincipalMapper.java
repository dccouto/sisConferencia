package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.MenuPrincipal;
import br.gov.mds.sisConferencia.service.dto.MenuPrincipalDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class MenuPrincipalMapper implements EntityMapper<MenuPrincipalDTO, MenuPrincipal>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        MenuPrincipalMapper.mapper = mapper;
    }

    @Override
    public MenuPrincipal toEntity(MenuPrincipalDTO menuPrincipalDTO) {
        return mapper.map(menuPrincipalDTO, MenuPrincipal.class);
    }

    @Override
    public MenuPrincipalDTO toDto(MenuPrincipal menuPrincipal) {
        return mapper.map(menuPrincipal, MenuPrincipalDTO.class);
    }

    @Override
    public List<MenuPrincipal> toEntity(List<MenuPrincipalDTO> menuPrincipalDTOList) {
        return menuPrincipalDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<MenuPrincipalDTO> toDto(List<MenuPrincipal> menuPrincipalList) {
        return menuPrincipalList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
