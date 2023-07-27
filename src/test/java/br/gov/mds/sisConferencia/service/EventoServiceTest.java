package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.repository.EventoRepository;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class EventoServiceTest {

    @Mock
    private EventoRepository repositoryMock;

    @Mock
    private EventoMapper mapperMock;

    @Spy
    @InjectMocks
    private EventoService eventoService;


    // Testes para os métodos herdados da classe GenericService

    @Test
    void testSalvar() {
        Evento evento = new Evento();
        when(repositoryMock.save(evento)).thenReturn(evento);

        Evento result = eventoService.save(evento);

        assertNotNull(result);
        assertEquals(evento, result);
        verify(repositoryMock, times(1)).save(evento);
    }

    @Test
    void testBuscarPorID_Encontrado() {
        Long id = 1L;
        Evento evento = new Evento();
        when(repositoryMock.findById(id)).thenReturn(Optional.of(evento));

        EventoDTO dto = new EventoDTO();
        when(mapperMock.toDto(evento)).thenReturn(dto);

        EventoDTO result = eventoService.buscarPorID(id);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(repositoryMock, times(1)).findById(id);
        verify(mapperMock, times(1)).toDto(evento);
    }

    @Test
    void testBuscarPorID_NaoEncontrado() {
        Long id = 1L;
        when(repositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(SisConferenciaNotFoundException.class, () -> eventoService.buscarPorID(id));

        verify(repositoryMock, times(1)).findById(id);
    }


    // Teste específico para o método não genérico "atualizar"
    /*
    @Test
    void testAtualizar() {
        Long id = 1L;
        Evento existingEvento = new Evento();
        when(repositoryMock.findById(id)).thenReturn(Optional.of(existingEvento));

        Evento eventoAtualizado = new Evento();
        eventoAtualizado.setNome("Novo Nome");

        when(repositoryMock.save(existingEvento)).thenReturn(existingEvento);

        Evento result = eventoService.atualizar(id, eventoAtualizado);

        assertNotNull(result);
        assertEquals(existingEvento, result);
        assertEquals(eventoAtualizado.getNome(), result.getNome());

        verify(repositoryMock, times(1)).findById(id);
        verify(repositoryMock, times(1)).save(existingEvento);
    }*/


    // Teste para verificar o método saveDTO

    @Test
    void testSaveDTO() {
        EventoDTO dto = new EventoDTO();
        Evento evento = new Evento();
        when(mapperMock.toEntity(dto)).thenReturn(evento);
        when(repositoryMock.save(evento)).thenReturn(evento);
        when(mapperMock.toDto(evento)).thenReturn(dto);

        EventoDTO result = eventoService.saveDTO(dto);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(mapperMock, times(1)).toEntity(dto);
        verify(repositoryMock, times(1)).save(evento);
        verify(mapperMock, times(1)).toDto(evento);
    }


}

