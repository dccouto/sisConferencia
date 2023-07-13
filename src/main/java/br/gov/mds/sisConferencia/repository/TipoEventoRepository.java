package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.gov.mds.sisConferencia.models.TipoEvento;

@Repository
public interface TipoEventoRepository extends JpaRepository<TipoEvento, Long> {
}