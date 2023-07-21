package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoConselheiroRepository extends JpaRepository<TipoConselheiro, Long> {

}
