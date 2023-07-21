package br.gov.mds.sisConferencia.service.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoFormato;
import br.gov.mds.sisConferencia.service.dto.TipoFormatoDTO;

@Component
@ComponentScan
public class TipoFormatoMapper implements EntityMapper<TipoFormatoDTO, TipoFormato> {

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoFormatoMapper.mapper = mapper;
    }

    @Override
    public TipoFormato toEntity(TipoFormatoDTO tipoFormatoDTO) {
        return mapper.map(tipoFormatoDTO, TipoFormato.class);
    }

    @Override
    public TipoFormatoDTO toDto(TipoFormato tipoFormato) {
        return mapper.map(tipoFormato, TipoFormatoDTO.class);
    }

    @Override
    public List<TipoFormato> toEntity(List<TipoFormatoDTO> tipoFormatoDTOList) {
        return tipoFormatoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoFormatoDTO> toDto(List<TipoFormato> tipoFormatoList) {
        return tipoFormatoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
