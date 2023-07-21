package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.Portaria;
import org.springframework.stereotype.Repository;

@Repository
public interface PortariaRepository extends JpaRepository<Portaria, Long> {

}
