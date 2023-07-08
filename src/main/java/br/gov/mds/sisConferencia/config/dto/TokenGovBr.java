package br.gov.mds.sisConferencia.config.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenGovBr {
    private String accessToken;
    private String idToken;
    private String hostCliente;
}
