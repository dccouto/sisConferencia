package br.gov.mds.sisConferencia.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Data;

@Embeddable
@Data
public class EventoEixoId implements Serializable {

    @Column(name = "FK_EVENTO")
    private Long eventoId;

    @Column(name = "FK_EIXO")
    private Long eixoId;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EventoEixoId other = (EventoEixoId) obj;
		return Objects.equals(eixoId, other.eixoId) && Objects.equals(eventoId, other.eventoId);
	}

	@Override
	public int hashCode() {
		return Objects.hash(eixoId, eventoId);
	}


	

    

}