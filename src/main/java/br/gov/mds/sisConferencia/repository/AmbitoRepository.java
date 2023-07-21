package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.Ambito;
import org.springframework.stereotype.Repository;

@Repository
public interface AmbitoRepository extends JpaRepository<Ambito, Long> {

}
