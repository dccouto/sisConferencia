package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.Documento;
import br.gov.mds.sisConferencia.service.dto.DocumentoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class DocumentoMapper implements EntityMapper<DocumentoDTO, Documento>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        DocumentoMapper.mapper = mapper;
    }

    @Override
    public Documento toEntity(DocumentoDTO documentoDTO) {
        return mapper.map(documentoDTO, Documento.class);
    }

    @Override
    public DocumentoDTO toDto(Documento documento) {
        return mapper.map(documento, DocumentoDTO.class);
    }

    @Override
    public List<Documento> toEntity(List<DocumentoDTO> documentoDTOList) {
        return documentoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<DocumentoDTO> toDto(List<Documento> documentoList) {
        return documentoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}