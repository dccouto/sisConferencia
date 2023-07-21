package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.service.TipoEventoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoEvento")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoEventoController {

	private final TipoEventoService tipoEventoService;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoEvento> create(@RequestBody TipoEvento tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.save(tipoEvento));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoEvento> update(@PathVariable Long id, @RequestBody TipoEvento tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.atualizar(id, tipoEvento));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoEvento>> getAll(@RequestHeader HttpHeaders responseHeaders) {
		List<TipoEvento> tipoEventos = tipoEventoService.findAll();
		// HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("X-Total-Count", String.valueOf(tipoEventos.size()));
		return new ResponseEntity<>(tipoEventos, responseHeaders, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoEvento> getById(@PathVariable Long id) {
		return ResponseEntity.ok(tipoEventoService.findById(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		tipoEventoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
