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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import br.gov.mds.sisConferencia.exceptions.SisConferenciaNotFoundException;
import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.repository.AcompanhanteRepository;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
import br.gov.mds.sisConferencia.service.mapper.AcompanhanteMapper;

@ExtendWith(MockitoExtension.class)
public class AcompanhanteServiceTest {

	@Mock
	private AcompanhanteRepository repositoryMock;

	@Mock
	private AcompanhanteMapper mapperMock;

	@Spy
	@InjectMocks
	private AcompanhanteService acompanhanteService;


	// Testes para os métodos herdados da classe GenericService

	@Test
	void testSalvar() {
		Acompanhante acompanhanate = new Acompanhante();
		when(repositoryMock.save(acompanhanate)).thenReturn(acompanhanate);

		Acompanhante result = acompanhanteService.save(acompanhanate);

		assertNotNull(result);
		assertEquals(acompanhanate, result);
		verify(repositoryMock, times(1)).save(acompanhanate);
	}

	@Test
	void testBuscarPorID_Encontrado() {
		Long id = 1L;
		Acompanhante acompanhanate = new Acompanhante();
		when(repositoryMock.findById(id)).thenReturn(Optional.of(acompanhanate));

		AcompanhanteDTO dto = new AcompanhanteDTO();
		when(mapperMock.toDto(acompanhanate)).thenReturn(dto);

		AcompanhanteDTO result = acompanhanteService.buscarPorID(id);

		assertNotNull(result);
		assertEquals(dto, result);
		verify(repositoryMock, times(1)).findById(id);
		verify(mapperMock, times(1)).toDto(acompanhanate);
	}

	@Test
	void testBuscarPorID_NaoEncontrado() {
		Long id = 1L;
		when(repositoryMock.findById(id)).thenReturn(Optional.empty());

		assertThrows(SisConferenciaNotFoundException.class, () -> acompanhanteService.buscarPorID(id));

		verify(repositoryMock, times(1)).findById(id);
	}


	// Testes específicos para o método não genérico "atualizar"

	@Test
	void testAtualizar() {
		Long id = 1L;
		Acompanhante acompanhanateExistente = new Acompanhante();
		when(repositoryMock.findById(id)).thenReturn(Optional.of(acompanhanateExistente));

		Acompanhante acompanhanateAtualizado = new Acompanhante();
		acompanhanateAtualizado.setNome("Novo Nome");

		when(repositoryMock.save(acompanhanateExistente)).thenReturn(acompanhanateExistente);

		Acompanhante result = acompanhanteService.atualizar(id, acompanhanateAtualizado);

		assertNotNull(result);
		assertEquals(acompanhanateExistente, result);
		assertEquals(acompanhanateAtualizado.getNome(), result.getNome());

		verify(repositoryMock, times(1)).findById(id);
		verify(repositoryMock, times(1)).save(acompanhanateExistente);
	}


	// Teste para verificar o método saveDTO

	@Test
	void testSaveDTO() {
		AcompanhanteDTO dto = new AcompanhanteDTO();
		Acompanhante acompanhanate = new Acompanhante();
		when(mapperMock.toEntity(dto)).thenReturn(acompanhanate);
		when(repositoryMock.save(acompanhanate)).thenReturn(acompanhanate);
		when(mapperMock.toDto(acompanhanate)).thenReturn(dto);

		AcompanhanteDTO result = acompanhanteService.saveDTO(dto);

		assertNotNull(result);
		assertEquals(dto, result);
		verify(mapperMock, times(1)).toEntity(dto);
		verify(repositoryMock, times(1)).save(acompanhanate);
		verify(mapperMock, times(1)).toDto(acompanhanate);
	}



}
