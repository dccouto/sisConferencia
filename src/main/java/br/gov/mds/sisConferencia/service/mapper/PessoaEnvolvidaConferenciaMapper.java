package br.gov.mds.sisConferencia.service.mapper;

import br.gov.mds.sisConferencia.models.PessoaEnvolvidaConferencia;
import br.gov.mds.sisConferencia.service.dto.PessoaEnvolvidaConferenciaDTO;
import org.modelmapper.ModelMapper;
import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.stream.Collectors;

@Component
@ComponentScan
public class PessoaEnvolvidaConferenciaMapper implements EntityMapper<PessoaEnvolvidaConferenciaDTO, PessoaEnvolvidaConferencia>{

    private static ModelMapper mapper;

    @Autowired
    public void setModelMapper(ModelMapper mapper) {
        PessoaEnvolvidaConferenciaMapper.mapper = mapper;
    }

    @Override
    public PessoaEnvolvidaConferencia toEntity(PessoaEnvolvidaConferenciaDTO pessoaEnvolvidaConferenciaDTO) {
        return mapper.map(pessoaEnvolvidaConferenciaDTO, PessoaEnvolvidaConferencia.class);
    }

    @Override
    public PessoaEnvolvidaConferenciaDTO toDto(PessoaEnvolvidaConferencia pessoaEnvolvidaConferencia) {
        return mapper.map(pessoaEnvolvidaConferencia, PessoaEnvolvidaConferenciaDTO.class);
    }

    @Override
    public List<PessoaEnvolvidaConferencia> toEntity(List<PessoaEnvolvidaConferenciaDTO> pessoaEnvolvidaConferenciaDTOList) {
        return pessoaEnvolvidaConferenciaDTOList.stream()
                .map(this::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public List<PessoaEnvolvidaConferenciaDTO> toDto(List<PessoaEnvolvidaConferencia> pessoaEnvolvidaConferenciaList) {
        return pessoaEnvolvidaConferenciaList.stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
}
