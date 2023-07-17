package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.sisConferencia.models.Ambito;
import br.gov.mds.sisConferencia.service.AmbitoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/ambito")
@RequiredArgsConstructor
public class AmbitoController {

	private final AmbitoService ambitoService;


	@PostMapping
	public ResponseEntity<Ambito> create(@RequestBody Ambito ambito) {
		return ResponseEntity.ok(ambitoService.save(ambito));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Ambito> update(@PathVariable Long id, @RequestBody Ambito ambito) {
		return ResponseEntity.ok(ambitoService.atualizar(id, ambito));
	}

	@GetMapping
	public ResponseEntity<List<Ambito>> getAll() {
		return ResponseEntity.ok(ambitoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Ambito> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ambitoService.findById(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		ambitoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}