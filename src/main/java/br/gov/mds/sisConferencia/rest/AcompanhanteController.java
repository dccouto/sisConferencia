package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Acompanhante;
import br.gov.mds.sisConferencia.service.AcompanhanteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/acompanhantes")
public class AcompanhanteController {

	private final AcompanhanteService acompanhanteService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Acompanhante>> listarTodos() {
		return ResponseEntity.ok(acompanhanteService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Acompanhante> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(acompanhanteService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Acompanhante> salvar(@RequestBody Acompanhante acompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(acompanhanteService.save(acompanhante));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Acompanhante> atualizar(@PathVariable Long id, @RequestBody Acompanhante acompanhanteAtualizado) {
		return ResponseEntity.ok(acompanhanteService.atualizar(id, acompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		acompanhanteService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
