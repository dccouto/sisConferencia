package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.TipoFormato;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoFormatoRepository extends JpaRepository<TipoFormato, Long> {

}
