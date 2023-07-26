package br.gov.mds.sisConferencia.models;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class EixoID implements Serializable {

    private static final long serialVersionUID = -8596378542258667273L;

    private Long id;

    private Long eventoId;

}
