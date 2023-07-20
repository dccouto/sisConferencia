package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Submenu;
import br.gov.mds.sisConferencia.service.dto.SubmenuDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class SubmenuMapper implements EntityMapper<SubmenuDTO, Submenu>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        SubmenuMapper.mapper = mapper;
    }

    @Override
    public Submenu toEntity(SubmenuDTO submenuDTO) {
        return mapper.map(submenuDTO, Submenu.class);
    }

    @Override
    public SubmenuDTO toDto(Submenu submenu) {
        return mapper.map(submenu, SubmenuDTO.class);
    }

    @Override
    public List<Submenu> toEntity(List<SubmenuDTO> submenuDTOList) {
        return submenuDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<SubmenuDTO> toDto(List<Submenu> submenuList) {
        return submenuList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
