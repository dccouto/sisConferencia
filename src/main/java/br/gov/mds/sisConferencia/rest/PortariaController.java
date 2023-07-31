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

import br.gov.mds.sisConferencia.service.PortariaService;
import br.gov.mds.sisConferencia.service.dto.PortariaDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/portaria")
@CrossOrigin(origins = "http://localhost:3000")
public class PortariaController {

	private final PortariaService portariaService;

	@GetMapping
	public ResponseEntity<List<PortariaDTO>> listarTodos() {
		return ResponseEntity.ok(portariaService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PortariaDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(portariaService.buscarPorID(id));

	}

	@PostMapping
	public ResponseEntity<PortariaDTO> salvar(@RequestBody PortariaDTO portaria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(portariaService.saveDTO(portaria));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PortariaDTO> atualizar(@PathVariable Long id, @RequestBody PortariaDTO portariaAtualizada) {
		return ResponseEntity.ok(portariaService.atualizar(id, portariaAtualizada));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		portariaService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
