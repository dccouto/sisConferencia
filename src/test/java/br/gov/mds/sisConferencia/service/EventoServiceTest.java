package br.gov.mds.sisConferencia.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
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
import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Eixo;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.repository.EixoRepository;
import br.gov.mds.sisConferencia.repository.EventoRepository;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.mapper.EventoMapper;
import br.gov.mds.sisConferencia.service.request.EventoRequest;

@ExtendWith(MockitoExtension.class)
public class EventoServiceTest {

    @Mock
    private EventoRepository repositoryMock;
    
    @Mock
    private EixoRepository eixoRepository;
    
    @Mock
    private ArquivoService arquivoService;

    @Mock
    private EventoMapper mapperMock;

    @Spy
    @InjectMocks
    private EventoService eventoService;



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


    @Test
	public void testSalvarEvento() {
		EventoRequest eventoRequest = new EventoRequest();
		Evento evento = new Evento();
		Arquivo arquivo = new Arquivo();
		arquivo.setId(1L); // Supondo que o ID foi gerado durante o salvamento
		evento.setImagem(arquivo);
		
		// Mock dos Eixos para salvar
		List<Eixo> eixos = new ArrayList<>();
		Eixo eixo1 = new Eixo();
		// Preencher os dados do eixo1
		eixos.add(eixo1);
		Eixo eixo2 = new Eixo();
		// Preencher os dados do eixo2
		eixos.add(eixo2);
		Evento eventoComEixo = evento;
		eventoComEixo.setEixos(eixos);
		
		when(mapperMock.requestToEntity(eventoRequest)).thenReturn(evento);
		when(mapperMock.toDto(eventoComEixo)).thenReturn(new EventoDTO());
		
		when(arquivoService.save(evento.getImagem())).thenReturn(arquivo);
		
		when(repositoryMock.save(evento)).thenReturn(eventoComEixo);
		
		when(eixoRepository.saveAll(any())).thenReturn(List.of(eixo1, eixo2));
		
		EventoDTO resultado = eventoService.salvar(eventoRequest);
		
		verify(arquivoService).save(evento.getImagem());
		verify(repositoryMock).save(evento);
		
		assertNotNull(resultado);
	}
    
    

    @Test
	public void testSalvarEventoSemEixo() {
		EventoRequest eventoRequest = new EventoRequest();
		Evento evento = new Evento();
		Arquivo arquivo = new Arquivo();
		arquivo.setId(1L); // Supondo que o ID foi gerado durante o salvamento
		evento.setImagem(arquivo);
		

		
		when(mapperMock.requestToEntity(eventoRequest)).thenReturn(evento);
		when(mapperMock.toDto(evento)).thenReturn(new EventoDTO());
		
		when(arquivoService.save(evento.getImagem())).thenReturn(arquivo);
		
		when(repositoryMock.save(evento)).thenReturn(evento);
		
		//when(eixoRepository.saveAll(any())).thenReturn(List.of(eixo1, eixo2));
		
		EventoDTO resultado = eventoService.salvar(eventoRequest);
		
		verify(arquivoService).save(evento.getImagem());
		verify(repositoryMock).save(evento);
		
		assertNotNull(resultado);
	}
    
    @Test
	public void testAtualizarEventoExistente() {
		Long id = 1L;
		EventoDTO eventoAtualizado = new EventoDTO();
		EventoRequest eventoRequest = new EventoRequest();
		eventoAtualizado.setId(id);
		
		when(repositoryMock.existsById(id)).thenReturn(true);
		when(eventoService.atualizar(eventoAtualizado)).thenReturn(eventoAtualizado);

		EventoDTO resultado = eventoService.atualizar(id, eventoRequest);
		
		verify(repositoryMock, times(1)).existsById(id);
		
		assertNotNull(resultado);
		assertEquals(eventoAtualizado, resultado);
	}

	@Test
	public void testAtualizarEventoInexistente() {
		Long id = 1L;
		EventoRequest eventoAtualizado = new EventoRequest();
		eventoAtualizado.setId(id);
		
		when(repositoryMock.existsById(id)).thenReturn(false);
		
		// Executar o método a ser testado e verificar se a exceção é lançada
		assertThrows(SisConferenciaNotFoundException.class, () -> {
			eventoService.atualizar(id, eventoAtualizado);
		});
		
		verify(repositoryMock, times(1)).existsById(id);
		
		verify(mapperMock, never()).toDto(new Evento());
	}


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

