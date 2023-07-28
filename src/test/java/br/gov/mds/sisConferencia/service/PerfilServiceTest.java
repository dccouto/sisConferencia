package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.repository.PerfilRepository;
import br.gov.mds.sisConferencia.service.dto.PerfilDTO;
import br.gov.mds.sisConferencia.service.mapper.PerfilMapper;

@ExtendWith(MockitoExtension.class)
public class PerfilServiceTest {

    @Mock
    private PerfilRepository repositoryMock;

    @Mock
    private PerfilMapper mapperMock;

    @Spy
    @InjectMocks
    private PerfilService perfilService;

    // Teste para o método save
    @Test
    void testSave() {
        Perfil perfil = new Perfil();
        perfil.setDescricao("Perfil de teste");

        when(repositoryMock.save(perfil)).thenReturn(perfil);

        Perfil result = perfilService.save(perfil);

        assertNotNull(result);
        assertEquals(perfil, result);
        verify(repositoryMock, times(1)).save(perfil);
    }

    // Teste para o método saveAll
    @Test
    void testSaveAll() {
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(new Perfil());
        perfis.add(new Perfil());

        List<Perfil> savedPerfis = new ArrayList<>(perfis);

        when(repositoryMock.saveAll(perfis)).thenReturn(savedPerfis);

        List<Perfil> result = perfilService.saveAll(perfis);

        assertNotNull(result);
        assertEquals(savedPerfis.size(), result.size());
        assertEquals(savedPerfis, result);
        verify(repositoryMock, times(1)).saveAll(perfis);
    }

    // Teste para o método saveDTO
    @Test
    void testSaveDTO() {
        PerfilDTO dto = new PerfilDTO();
        Perfil perfil = new Perfil();
        when(mapperMock.toEntity(dto)).thenReturn(perfil);
        when(repositoryMock.save(perfil)).thenReturn(perfil);
        when(mapperMock.toDto(perfil)).thenReturn(dto);

        PerfilDTO result = perfilService.saveDTO(dto);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(mapperMock, times(1)).toEntity(dto);
        verify(repositoryMock, times(1)).save(perfil);
        verify(mapperMock, times(1)).toDto(perfil);
    }

    // Teste para o método saveAllDTO
    @Test
    void testSaveAllDTO() {
        List<PerfilDTO> dtos = new ArrayList<>();
        dtos.add(new PerfilDTO());
        dtos.add(new PerfilDTO());

        List<Perfil> perfis = new ArrayList<>();
        perfis.add(new Perfil());
        perfis.add(new Perfil());

        when(mapperMock.toEntity(dtos)).thenReturn(perfis);
        when(repositoryMock.saveAll(perfis)).thenReturn(perfis);
        when(mapperMock.toDto(perfis)).thenReturn(dtos);

        List<PerfilDTO> result = perfilService.saveAllDTO(dtos);

        assertNotNull(result);
        assertEquals(dtos.size(), result.size());
        assertEquals(dtos, result);
        verify(mapperMock, times(1)).toEntity(dtos);
        verify(repositoryMock, times(1)).saveAll(perfis);
        verify(mapperMock, times(1)).toDto(perfis);
    }
/*
    // Teste para o método atualizar (herdado de GenericService)
    @Test
    void testAtualizar() {
        Long id = 1L;
        Perfil perfilExistente = new Perfil();
        when(repositoryMock.findById(id)).thenReturn(Optional.of(perfilExistente));

        Perfil perfilAtualizado = new Perfil();
        perfilAtualizado.setDescricao("Novo Perfil");

        when(repositoryMock.save(perfilExistente)).thenReturn(perfilExistente);

        Perfil result = perfilService.atualizar(id, perfilAtualizado);

        assertNotNull(result);
        assertEquals(perfilExistente, result);
        assertEquals(perfilAtualizado.getDescricao(), result.getDescricao());

        verify(repositoryMock, times(1)).findById(id);
        verify(repositoryMock, times(1)).save(perfilExistente);
    }
*/
    @Test
    void testDelete() {
        Long id = 1L;
        Perfil perfil = new Perfil();

        perfilService.delete(id);

        verify(repositoryMock, times(1)).deleteById(id);
    }

    @Test
    void testBuscarTodos() {
        List<Perfil> perfis = new ArrayList<>();
        perfis.add(new Perfil());
        perfis.add(new Perfil());

        when(repositoryMock.findAll()).thenReturn(perfis);

        List<PerfilDTO> dtos = new ArrayList<>();
        dtos.add(new PerfilDTO());
        dtos.add(new PerfilDTO());

        when(mapperMock.toDto(perfis)).thenReturn(dtos);

        List<PerfilDTO> result = perfilService.buscarTodos();

        assertNotNull(result);
        assertEquals(dtos.size(), result.size());
        assertEquals(dtos, result);
        verify(repositoryMock, times(1)).findAll();
        verify(mapperMock, times(1)).toDto(perfis);
    }

    // Teste para o método buscarPorID (herdado de GenericService)
    @Test
    void testBuscarPorID_Encontrado() {
        Long id = 1L;
        Perfil perfil = new Perfil();
        when(repositoryMock.findById(id)).thenReturn(Optional.of(perfil));

        PerfilDTO dto = new PerfilDTO();
        when(mapperMock.toDto(perfil)).thenReturn(dto);

        PerfilDTO result = perfilService.buscarPorID(id);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(repositoryMock, times(1)).findById(id);
        verify(mapperMock, times(1)).toDto(perfil);
    }

    @Test
    void testBuscarPorID_NaoEncontrado() {
        Long id = 1L;
        when(repositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(SisConferenciaNotFoundException.class, () -> perfilService.buscarPorID(id));

        verify(repositoryMock, times(1)).findById(id);
    }

    @Test
    void testFindById_Encontrado() {
        Long id = 1L;
        Perfil perfil = new Perfil();
        when(repositoryMock.findById(id)).thenReturn(Optional.of(perfil));

        perfilService.findById(id);


        verify(repositoryMock, times(1)).findById(id);
    }

    @Test
    void testFindById_NaoEncontrado() {
        Long id = 1L;
        when(repositoryMock.findById(id)).thenReturn(Optional.empty());

        assertThrows(SisConferenciaNotFoundException.class, () -> perfilService.findById(id));

        verify(repositoryMock, times(1)).findById(id);
    }
}

