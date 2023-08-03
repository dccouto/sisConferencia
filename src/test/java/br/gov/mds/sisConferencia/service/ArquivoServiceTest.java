package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.repository.ArquivoRepository;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;

@ExtendWith(MockitoExtension.class)
public class ArquivoServiceTest {

	@Mock
	private ArquivoRepository repositoryMock;

	@Mock
	private EntityMapper<ArquivoDTO, Arquivo> mapperMock;

	@Spy
	@InjectMocks
	private ArquivoService arquivoService;


	@Test
	void testSalvar() {
		Arquivo arquivo = new Arquivo();
		when(repositoryMock.save(arquivo)).thenReturn(arquivo);

		Arquivo result = arquivoService.save(arquivo);

		assertNotNull(result);
		assertEquals(arquivo, result);
		verify(repositoryMock, times(1)).save(arquivo);
	}

	@Test
	void testBuscarPorID_Encontrado() {
		Long id = 1L;
		Arquivo arquivo = new Arquivo();
		when(repositoryMock.findById(id)).thenReturn(java.util.Optional.of(arquivo));

		ArquivoDTO dto = new ArquivoDTO();
		when(mapperMock.toDto(arquivo)).thenReturn(dto);

		ArquivoDTO result = arquivoService.buscarPorID(id);

		assertNotNull(result);
		assertEquals(dto, result);
		verify(repositoryMock, times(1)).findById(id);
		verify(mapperMock, times(1)).toDto(arquivo);
	}
	
    @Test
    void testFindAll() {
        List<Arquivo> arquivos = new ArrayList<>();
        arquivos.add(new Arquivo());
        arquivos.add(new Arquivo());

        when(repositoryMock.findAll()).thenReturn(arquivos);

        List<Arquivo> result = arquivoService.findAll();

        assertNotNull(result);
        assertEquals(arquivos.size(), result.size());
        assertEquals(arquivos, result);
        verify(repositoryMock, times(1)).findAll();
    }
	
    @Test
    void testSaveAll() {
        List<Arquivo> arquivos = new ArrayList<>();
        arquivos.add(new Arquivo());
        arquivos.add(new Arquivo());

        List<Arquivo> arquivosSalvos = new ArrayList<>();
        arquivosSalvos.add(new Arquivo());
        arquivosSalvos.add(new Arquivo());

        when(repositoryMock.saveAll(arquivos)).thenReturn(arquivosSalvos);

        List<Arquivo> result = arquivoService.saveAll(arquivos);

        assertNotNull(result);
        assertEquals(arquivosSalvos.size(), result.size());
        assertEquals(arquivosSalvos, result);
        verify(repositoryMock, times(1)).saveAll(arquivos);
    }

	@Test
	void testBuscarPorID_NaoEncontrado() {
		Long id = 1L;
		when(repositoryMock.findById(id)).thenReturn(java.util.Optional.empty());

		assertThrows(SisConferenciaNotFoundException.class, () -> arquivoService.buscarPorID(id));

		verify(repositoryMock, times(1)).findById(id);
	}

	// Teste específico para o método não genérico "atualizar"
/*
	@Test
	void testAtualizar() {
		Long id = 1L;
		Arquivo existingArquivo = new Arquivo();
		when(repositoryMock.findById(id)).thenReturn(java.util.Optional.of(existingArquivo));

		Arquivo arquivoAtualizado = new Arquivo();
		arquivoAtualizado.setByteArquivo("Novo conteúdo do arquivo".getBytes());

		when(repositoryMock.save(existingArquivo)).thenReturn(existingArquivo);

		Arquivo result = arquivoService.atualizar(id, arquivoAtualizado);

		assertNotNull(result);
		assertEquals(existingArquivo, result);
		assertEquals(arquivoAtualizado.getByteArquivo(), result.getByteArquivo());

		verify(repositoryMock, times(1)).findById(id);
		verify(repositoryMock, times(1)).save(existingArquivo);
	}
*/
	// Teste para verificar o método saveDTO

	@Test
	void testSaveDTO() {
		ArquivoDTO dto = new ArquivoDTO();
		Arquivo arquivo = new Arquivo();
		when(mapperMock.toEntity(dto)).thenReturn(arquivo);
		when(repositoryMock.save(arquivo)).thenReturn(arquivo);
		when(mapperMock.toDto(arquivo)).thenReturn(dto);

		ArquivoDTO result = arquivoService.saveDTO(dto);

		assertNotNull(result);
		assertEquals(dto, result);
		verify(mapperMock, times(1)).toEntity(dto);
		verify(repositoryMock, times(1)).save(arquivo);
		verify(mapperMock, times(1)).toDto(arquivo);
	}


	@Test
	void testBuscarTodos() {
		List<Arquivo> arquivos = new ArrayList<>();
		arquivos.add(new Arquivo());
		arquivos.add(new Arquivo());
		when(repositoryMock.findAll()).thenReturn(arquivos);

		List<ArquivoDTO> dtos = new ArrayList<>();
		dtos.add(new ArquivoDTO());
		dtos.add(new ArquivoDTO());
		when(mapperMock.toDto(arquivos)).thenReturn(dtos);

		List<ArquivoDTO> result = arquivoService.buscarTodos();

		assertNotNull(result);
		assertEquals(dtos.size(), result.size());
		verify(repositoryMock, times(1)).findAll();
		verify(mapperMock, times(1)).toDto(arquivos);
	}

	// Teste para o método delete

	@Test
	void testDelete() {
		Long id = 1L;

		arquivoService.delete(id);

		verify(repositoryMock, times(1)).deleteById(id);
	}

}
