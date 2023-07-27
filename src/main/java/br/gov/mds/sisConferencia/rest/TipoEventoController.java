package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
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
	public ResponseEntity<TipoEventoDTO> create(@RequestBody TipoEventoDTO tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.saveDTO(tipoEvento));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoEventoDTO> update(@PathVariable Long id, @RequestBody TipoEventoDTO tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.atualizar(id, tipoEvento));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoEventoDTO>> getAll(@RequestHeader HttpHeaders responseHeaders) {
		List<TipoEventoDTO> tipoEventos = tipoEventoService.buscarTodos();
		responseHeaders.set("X-Total-Count", String.valueOf(tipoEventos.size()));
		return new ResponseEntity<>(tipoEventos, responseHeaders, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoEventoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(tipoEventoService.buscarPorID(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		tipoEventoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
