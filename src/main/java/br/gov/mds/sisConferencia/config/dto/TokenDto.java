package br.gov.mds.sisConferencia.config.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {

    private String accessToken;
    private String refreshToken;
    private String tokenType;

}
