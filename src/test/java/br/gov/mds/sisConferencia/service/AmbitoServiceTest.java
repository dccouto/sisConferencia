package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.repository.AmbitoRepository;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import br.gov.mds.sisConferencia.service.mapper.AmbitoMapper;

@ExtendWith(MockitoExtension.class)
@RunWith(MockitoJUnitRunner.class)
public class AmbitoServiceTest {

    @Mock
    private AmbitoRepository repositoryMock;

    @Mock
    private AmbitoMapper mapperMock;

    @Spy
    @InjectMocks
    private AmbitoService ambitoService;


    // Testes para os métodos herdados da classe GenericService

    @Test
    void testSalvar() {
        Ambito ambito = new Ambito();
        when(repositoryMock.save(ambito)).thenReturn(ambito);

        Ambito result = ambitoService.save(ambito);

        assertNotNull(result);
        assertEquals(ambito, result);
        verify(repositoryMock, times(1)).save(ambito);
    }

    @Test
    void testBuscarPorID_Encontrado() {
        Long id = 1L;
        Ambito ambito = new Ambito();
        when(repositoryMock.findById(id)).thenReturn(java.util.Optional.of(ambito));

        AmbitoDTO dto = new AmbitoDTO();
        when(mapperMock.toDto(ambito)).thenReturn(dto);

        AmbitoDTO result = ambitoService.buscarPorID(id);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(repositoryMock, times(1)).findById(id);
        verify(mapperMock, times(1)).toDto(ambito);
    }

    @Test
    void testBuscarPorID_NaoEncontrado() {
        Long id = 1L;
        when(repositoryMock.findById(id)).thenReturn(java.util.Optional.empty());

        assertThrows(SisConferenciaNotFoundException.class, () -> ambitoService.buscarPorID(id));

        verify(repositoryMock, times(1)).findById(id);
    }


    // Teste específico para o método não genérico "atualizar"
/*
    @Test
    void testAtualizar() {
        Long id = 1L;
        Ambito existingAmbito = new Ambito();
        when(repositoryMock.findById(id)).thenReturn(java.util.Optional.of(existingAmbito));

        Ambito ambitoAtualizado = new Ambito();
        ambitoAtualizado.setDescricao("Nova descrição");

        when(repositoryMock.save(existingAmbito)).thenReturn(existingAmbito);

        Ambito result = ambitoService.atualizar(id, ambitoAtualizado);

        assertNotNull(result);
        assertEquals(existingAmbito, result);
        assertEquals(ambitoAtualizado.getDescricao(), result.getDescricao());

        verify(repositoryMock, times(1)).findById(id);
        verify(repositoryMock, times(1)).save(existingAmbito);
    }

*/
    // Teste para verificar o método saveDTO

    @Test
    void testSaveDTO() {
        AmbitoDTO dto = new AmbitoDTO();
        Ambito ambito = new Ambito();
        when(mapperMock.toEntity(dto)).thenReturn(ambito);
        when(repositoryMock.save(ambito)).thenReturn(ambito);
        when(mapperMock.toDto(ambito)).thenReturn(dto);

        AmbitoDTO result = ambitoService.saveDTO(dto);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(mapperMock, times(1)).toEntity(dto);
        verify(repositoryMock, times(1)).save(ambito);
        verify(mapperMock, times(1)).toDto(ambito);
    }


}
