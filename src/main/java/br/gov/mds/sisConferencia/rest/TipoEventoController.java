package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.sisConferencia.service.TipoEventoService;
import br.gov.mds.sisConferencia.service.dto.TipoEventoDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoEvento")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoEventoController {

	private final TipoEventoService tipoEventoService;

	@PostMapping
	public ResponseEntity<TipoEventoDTO> create(@RequestBody TipoEventoDTO tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.saveDTO(tipoEvento));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoEventoDTO> update(@PathVariable Long id, @RequestBody TipoEventoDTO tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.atualizar(id, tipoEvento));
	}

	@GetMapping
	public ResponseEntity<List<TipoEventoDTO>> getAll(@RequestHeader HttpHeaders responseHeaders) {
		List<TipoEventoDTO> tipoEventos = tipoEventoService.buscarTodos();
		responseHeaders.set("X-Total-Count", String.valueOf(tipoEventos.size()));
		return new ResponseEntity<>(tipoEventos, responseHeaders, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEventoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(tipoEventoService.buscarPorID(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		tipoEventoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
