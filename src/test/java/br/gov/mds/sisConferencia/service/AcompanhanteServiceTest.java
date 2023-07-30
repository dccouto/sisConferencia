package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
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


	  @Test
	    void testAtualizar_Existente() {
	        Long id = 1L;
	        AcompanhanteDTO acompanhanteDTO = new AcompanhanteDTO();
	        Acompanhante acompanhanteEntity = new Acompanhante();

	        when(mapperMock.toEntity(acompanhanteDTO)).thenReturn(acompanhanteEntity);
	        when(mapperMock.toDto(acompanhanteEntity)).thenReturn(acompanhanteDTO);

	        when(repositoryMock.existsById(id)).thenReturn(true);

	        when(acompanhanteService.atualizar(acompanhanteDTO)).thenReturn(acompanhanteDTO);

	        AcompanhanteDTO result = acompanhanteService.atualizar(id, acompanhanteDTO);

	        assertEquals(acompanhanteDTO, result);

	        verify(repositoryMock, times(1)).existsById(id);

	        verify(acompanhanteService, times(1)).atualizar(acompanhanteDTO);

	        verify(mapperMock, times(1)).toEntity(acompanhanteDTO);
	        verify(mapperMock, times(1)).toDto(acompanhanteEntity);
	    }

	    @Test
	    void testAtualizar_NaoExistente() {
	        Long id = 1L;
	        AcompanhanteDTO acompanhanteDTO = new AcompanhanteDTO();

	        when(repositoryMock.existsById(id)).thenReturn(false);
	        assertThrows(SisConferenciaNotFoundException.class, () -> acompanhanteService.atualizar(id, acompanhanteDTO));
	        verify(repositoryMock, times(1)).existsById(id);
	        verify(acompanhanteService, never()).atualizar(acompanhanteDTO);
	        verify(mapperMock, never()).toEntity(acompanhanteDTO);
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
