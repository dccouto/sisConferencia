package br.gov.mds.sisConferencia.service.dto;

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.RelatorioEvento;
import br.gov.mds.sisConferencia.models.TipoDocumento;
import br.gov.mds.sisConferencia.models.Usuario;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DocumentoDTO {

    private Long id;

    private LocalDate dataEnvio;

    private TipoDocumento tipoDocumento;

    private Arquivo arquivo;

    private Usuario usuarioEnvio;

    private List<RelatorioEvento> relatoriosEventos;
}
