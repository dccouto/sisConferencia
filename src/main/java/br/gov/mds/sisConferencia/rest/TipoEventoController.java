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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	public ResponseEntity<TipoEvento> create(@RequestBody TipoEvento tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.save(tipoEvento));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoEvento> update(@PathVariable Long id, @RequestBody TipoEvento tipoEvento) {
		return ResponseEntity.ok(tipoEventoService.atualizar(id, tipoEvento));
	}

	@GetMapping
	public  ResponseEntity<List<TipoEvento>> getAll() {
		
		return ResponseEntity.ok(tipoEventoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoEvento> getById(@PathVariable Long id) {
		return ResponseEntity.ok(tipoEventoService.findById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		tipoEventoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
