package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoInscricaoMapper implements EntityMapper<TipoInscricaoDTO, TipoInscricao> {

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoInscricaoMapper.mapper = mapper;
    }

    @Override
    public TipoInscricao toEntity(TipoInscricaoDTO tipoInscricaoDTO) {
        return mapper.map(tipoInscricaoDTO, TipoInscricao.class);
    }

    @Override
    public TipoInscricaoDTO toDto(TipoInscricao tipoInscricao) {
        return mapper.map(tipoInscricao, TipoInscricaoDTO.class);
    }

    @Override
    public List<TipoInscricao> toEntity(List<TipoInscricaoDTO> tipoInscricaoDTOList) {
        return tipoInscricaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoInscricaoDTO> toDto(List<TipoInscricao> tipoInscricaoList) {
        return tipoInscricaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
