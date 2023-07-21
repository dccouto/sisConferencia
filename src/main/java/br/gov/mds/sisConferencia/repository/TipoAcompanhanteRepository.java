package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoAcompanhanteRepository extends JpaRepository<TipoAcompanhante, Long> {

}
