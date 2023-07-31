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

import br.gov.mds.sisConferencia.service.AcompanhanteService;
import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/acompanhantes")
public class AcompanhanteController {

	private final AcompanhanteService acompanhanteService;

	@GetMapping
	public ResponseEntity<List<AcompanhanteDTO>> listarTodos() {
		return ResponseEntity.ok(acompanhanteService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<AcompanhanteDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(acompanhanteService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<AcompanhanteDTO> salvar(@RequestBody AcompanhanteDTO acompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(acompanhanteService.saveDTO(acompanhante));
	}

	@PutMapping("/{id}")
	public ResponseEntity<AcompanhanteDTO> atualizar(@PathVariable Long id, @RequestBody AcompanhanteDTO acompanhanteAtualizado) {
		return ResponseEntity.ok(acompanhanteService.atualizar(id, acompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		acompanhanteService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
