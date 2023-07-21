package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.TipoInscricao;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoInscricaoRepository extends JpaRepository<TipoInscricao, Long> {

}
