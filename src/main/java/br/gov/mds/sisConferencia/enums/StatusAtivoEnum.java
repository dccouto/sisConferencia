package br.gov.mds.sisConferencia.enums;

public enum StatusAtivoEnum {

    SIM(Boolean.TRUE), NAO(Boolean.FALSE);

    private Boolean status;

    StatusAtivoEnum(Boolean status) {
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

}
