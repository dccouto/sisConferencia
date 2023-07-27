package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.AmbitoDTO;
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
	public ResponseEntity<AmbitoDTO> create(@RequestBody AmbitoDTO ambito) {
		return ResponseEntity.ok(ambitoService.saveDTO(ambito));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AmbitoDTO> update(@PathVariable Long id, @RequestBody AmbitoDTO ambito) {
		return ResponseEntity.ok(ambitoService.atualizar(id, ambito));
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<AmbitoDTO>> getAll() {
		return ResponseEntity.ok(ambitoService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AmbitoDTO> getById(@PathVariable Long id) {
		return ResponseEntity.ok(ambitoService.buscarPorID(id));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<HttpStatus> delete(@PathVariable Long id) {
		ambitoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}