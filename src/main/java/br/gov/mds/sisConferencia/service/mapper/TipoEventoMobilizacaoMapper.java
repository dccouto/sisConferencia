package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoEventoMobilizacao;
import br.gov.mds.sisConferencia.service.dto.TipoEventoMobilizacaoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoEventoMobilizacaoMapper implements EntityMapper<TipoEventoMobilizacaoDTO, TipoEventoMobilizacao>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoEventoMobilizacaoMapper.mapper = mapper;
    }

    @Override
    public TipoEventoMobilizacao toEntity(TipoEventoMobilizacaoDTO tipoEventoMobilizacaoDTO) {
        return mapper.map(tipoEventoMobilizacaoDTO, TipoEventoMobilizacao.class);
    }

    @Override
    public TipoEventoMobilizacaoDTO toDto(TipoEventoMobilizacao tipoEventoMobilizacao) {
        return mapper.map(tipoEventoMobilizacao, TipoEventoMobilizacaoDTO.class);
    }

    @Override
    public List<TipoEventoMobilizacao> toEntity(List<TipoEventoMobilizacaoDTO> tipoEventoMobilizacaoDTOList) {
        return tipoEventoMobilizacaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoEventoMobilizacaoDTO> toDto(List<TipoEventoMobilizacao> tipoEventoMobilizacaoList) {
        return tipoEventoMobilizacaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
