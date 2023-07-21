package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.service.EventoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventoController {

	private final EventoService eventoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Evento>> listarTodos() {
		return ResponseEntity.ok(eventoService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(eventoService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Evento> salvar(@RequestBody Evento evento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.save(evento));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
		return ResponseEntity.ok(eventoService.atualizar(id, eventoAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		eventoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
