package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.service.AmbitoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ambito")
public class AmbitoController {

	private final AmbitoService ambitoService;

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Ambito> create(@RequestBody Ambito ambito) {
		return ResponseEntity.ok(ambitoService.save(ambito));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Ambito> update(@PathVariable Long id, @RequestBody Ambito ambito) {
		return ResponseEntity.ok(ambitoService.atualizar(id, ambito));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Ambito>> getAll() {
		return ResponseEntity.ok(ambitoService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Ambito> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ambitoService.findById(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		ambitoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}