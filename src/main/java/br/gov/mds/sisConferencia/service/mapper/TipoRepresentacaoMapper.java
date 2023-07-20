package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.TipoRepresentacao;
import br.gov.mds.sisConferencia.service.dto.TipoRepresentacaoDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class TipoRepresentacaoMapper implements EntityMapper<TipoRepresentacaoDTO, TipoRepresentacao>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        TipoRepresentacaoMapper.mapper = mapper;
    }

    @Override
    public TipoRepresentacao toEntity(TipoRepresentacaoDTO tipoRepresentacaoDTO) {
        return mapper.map(tipoRepresentacaoDTO, TipoRepresentacao.class);
    }

    @Override
    public TipoRepresentacaoDTO toDto(TipoRepresentacao tipoRepresentacao) {
        return mapper.map(tipoRepresentacao, TipoRepresentacaoDTO.class);
    }

    @Override
    public List<TipoRepresentacao> toEntity(List<TipoRepresentacaoDTO> tipoRepresentacaoDTOList) {
        return tipoRepresentacaoDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<TipoRepresentacaoDTO> toDto(List<TipoRepresentacao> tipoRepresentacaoList) {
        return tipoRepresentacaoList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
