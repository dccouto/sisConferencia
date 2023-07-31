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

import br.gov.mds.sisConferencia.service.AmbitoService;
import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ambito")
public class AmbitoController {

	private final AmbitoService ambitoService;

	@PostMapping
	public ResponseEntity<AmbitoDTO> create(@RequestBody AmbitoDTO ambito) {
		return ResponseEntity.ok(ambitoService.saveDTO(ambito));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AmbitoDTO> update(@PathVariable Long id, @RequestBody AmbitoDTO ambito) {
		return ResponseEntity.ok(ambitoService.atualizar(id, ambito));
	}

	@GetMapping
	public ResponseEntity<List<AmbitoDTO>> getAll() {
		return ResponseEntity.ok(ambitoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AmbitoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ambitoService.buscarPorID(id));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		ambitoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}