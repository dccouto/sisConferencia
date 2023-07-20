package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoDocumento;
import br.gov.mds.sisConferencia.service.dto.TipoDocumentoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoDocumentoMapper implements EntityMapper<TipoDocumentoDTO, TipoDocumento>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoDocumentoMapper.mapper = mapper;
    }

    @Override
    public TipoDocumento toEntity(TipoDocumentoDTO tipoDocumentoDTO) {
        return mapper.map(tipoDocumentoDTO, TipoDocumento.class);
    }

    @Override
    public TipoDocumentoDTO toDto(TipoDocumento tipoDocumento) {
        return mapper.map(tipoDocumento, TipoDocumentoDTO.class);
    }

    @Override
    public List<TipoDocumento> toEntity(List<TipoDocumentoDTO> tipoDocumentoDTOList) {
        return tipoDocumentoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoDocumentoDTO> toDto(List<TipoDocumento> tipoDocumentoList) {
        return tipoDocumentoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
