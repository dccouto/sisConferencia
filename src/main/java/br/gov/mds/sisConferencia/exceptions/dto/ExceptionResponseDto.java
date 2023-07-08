package br.gov.mds.sisConferencia.exceptions.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExceptionResponseDto {

    private LocalDateTime dataTime;
    private String mensagem;
    private String detalhes;

}
