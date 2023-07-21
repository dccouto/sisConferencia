package br.gov.mds.sisConferencia.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.gov.mds.sisConferencia.models.Arquivo;

public interface ArquivoRepository extends JpaRepository<Arquivo, Long> {

}
