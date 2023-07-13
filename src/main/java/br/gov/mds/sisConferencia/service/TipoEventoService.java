package br.gov.mds.sisConferencia.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.repository.TipoEventoRepository;

@Service
public class TipoEventoService {

    private final TipoEventoRepository tipoEventoRepository;

    @Autowired
    public TipoEventoService(TipoEventoRepository tipoEventoRepository) {
        this.tipoEventoRepository = tipoEventoRepository;
    }

    public TipoEvento save(TipoEvento tipoEvento) {
        return tipoEventoRepository.save(tipoEvento);
    }

    public void delete(Long id) {
        tipoEventoRepository.deleteById(id);
    }

    public List<TipoEvento> findAll() {
        return tipoEventoRepository.findAll();
    }

    public TipoEvento findById(Long id) {
        return tipoEventoRepository.findById(id).orElse(null);
    }

    public TipoEvento update(Long id, TipoEvento tipoEvento) {
        TipoEvento existingTipoEvento = findById(id);
        if (existingTipoEvento != null) {
            existingTipoEvento.setDescricao(tipoEvento.getDescricao());
            return tipoEventoRepository.save(existingTipoEvento);
        }
        return null;
    }
}