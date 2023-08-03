package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.sisConferencia.service.ArquivoService;
import br.gov.mds.sisConferencia.service.EventoService;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.request.EventoRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "http://localhost:3000")
public class EventoController {

	private final EventoService eventoService;
	private final ArquivoService arquivoService;


	@GetMapping
	public ResponseEntity<List<EventoDTO>> listarTodos() {
		return ResponseEntity.ok(eventoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<EventoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(eventoService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<EventoDTO> salvar(@RequestBody EventoRequest eventoRequest) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.salvar(eventoRequest));
	}

	@PutMapping("/{id}")
	public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @RequestBody EventoRequest eventoAtualizado) {
		return ResponseEntity.ok(eventoService.atualizar(id, eventoAtualizado));
	}
	
	@PostMapping("/{idEvento}/arquivo")
	public ResponseEntity<EventoDTO> inserirImagem(@PathVariable Long idEvento, @RequestBody ArquivoDTO arquivoDTO) {
		EventoDTO evento = eventoService.buscarPorID(idEvento);
		ArquivoDTO imagem = arquivoService.saveDTO(arquivoDTO);
		evento.setImagem(imagem);
		return ResponseEntity.ok(eventoService.saveDTO(evento));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		eventoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
