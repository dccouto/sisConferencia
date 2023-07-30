package br.gov.mds.sisConferencia.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import br.gov.mds.sisConferencia.util.Schemas;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_EVENTO_EIXO", schema = Schemas.SISCONFERENCIA)
public class EventoEixo {
 
    @EmbeddedId
    private EventoEixoId id;
 
//    @ManyToOne
//    @MapsId("FK_EVENTO")
//    private Evento evento;
// 
//    @ManyToOne
//    @MapsId("FK_EIXO")
//    private Eixo eixo;
}