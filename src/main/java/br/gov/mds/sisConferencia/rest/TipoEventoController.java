package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.sisConferencia.models.TipoEvento;
import br.gov.mds.sisConferencia.service.TipoEventoService;

@RestController
@RequestMapping("/tipoEvento")
public class TipoEventoController {

	private final TipoEventoService tipoEventoService;

	@Autowired
	public TipoEventoController(TipoEventoService tipoEventoService) {
		this.tipoEventoService = tipoEventoService;
	}

	@PostMapping
	public ResponseEntity<TipoEvento> create(@RequestBody TipoEvento tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.save(tipoEvento));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoEvento> update(@PathVariable Long id, @RequestBody TipoEvento tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.atualizar(id, tipoEvento));
	}

	@GetMapping
	public ResponseEntity<List<TipoEvento>> getAll() {
		List<TipoEvento> tipoEventos = tipoEventoService.findAll();
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("X-Total-Count", String.valueOf(tipoEventos.size()));
		return new ResponseEntity<>(tipoEventos, responseHeaders, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEvento> getById(@PathVariable Long id) {
		return ResponseEntity.ok(tipoEventoService.findById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		try {
			tipoEventoService.delete(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
