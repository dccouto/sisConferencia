package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.service.PortariaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/portaria")
public class PortariaController {

	private final PortariaService portariaService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Portaria>> listarTodos() {
		return ResponseEntity.ok(portariaService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Portaria> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(portariaService.findById(id));

	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Portaria> salvar(@RequestBody Portaria portaria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(portariaService.save(portaria));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Portaria> atualizar(@PathVariable Long id, @RequestBody Portaria portariaAtualizada) {
		return ResponseEntity.ok(portariaService.atualizar(id, portariaAtualizada));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		portariaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
