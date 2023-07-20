package br.gov.mds.sisConferencia.rest;

import java.util.List;

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

import br.gov.mds.sisConferencia.models.Portaria;
import br.gov.mds.sisConferencia.service.PortariaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/portaria")
@CrossOrigin(origins = "http://localhost:3000")
public class PortariaController {

	private final PortariaService portariaService;

	@GetMapping
	public ResponseEntity<List<Portaria>> listarTodos() {
		return ResponseEntity.ok(portariaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Portaria> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(portariaService.findById(id));

	}

	@PostMapping
	public ResponseEntity<Portaria> salvar(@RequestBody Portaria portaria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(portariaService.save(portaria));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Portaria> atualizar(@PathVariable Long id, @RequestBody Portaria portariaAtualizada) {
		return ResponseEntity.ok(portariaService.atualizar(id, portariaAtualizada));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		portariaService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
