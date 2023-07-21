package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.Acompanhante;
import org.springframework.stereotype.Repository;

@Repository
public interface AcompanhanteRepository extends JpaRepository<Acompanhante, Long> {

}
