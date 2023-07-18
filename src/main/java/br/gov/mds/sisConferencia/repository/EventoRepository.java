package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.Evento;

public interface EventoRepository extends JpaRepository<Evento, Long> {

}
