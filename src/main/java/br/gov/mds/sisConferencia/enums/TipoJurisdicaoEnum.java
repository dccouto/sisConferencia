package br.gov.mds.sisConferencia.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum TipoJurisdicaoEnum {
    MUNICIPIO(1, "Município"),
    ESTADO_DF(2, "Estado ou DF"),
    UNIAO(3, "União");

    private final int valor;
    private final String descricao;


    // Método para obter o enum a partir do valor numérico
    public static TipoJurisdicaoEnum getByValor(int valor) {
        for (TipoJurisdicaoEnum type : TipoJurisdicaoEnum.values()) {
            if (type.valor == valor) {
                return type;
            }
        }
        throw new IllegalArgumentException("Valor inválido para TipoJurisdicaoEnum: " + valor);
    }

    // Método para obter o enum a partir da descrição (string)
    public static TipoJurisdicaoEnum getByDescricao(String descricao) {
        for (TipoJurisdicaoEnum type : TipoJurisdicaoEnum.values()) {
            if (type.descricao.equalsIgnoreCase(descricao)) {
                return type;
            }
        }
        throw new IllegalArgumentException("Descrição inválida para TipoJurisdicaoEnum: " + descricao);
    }
}
