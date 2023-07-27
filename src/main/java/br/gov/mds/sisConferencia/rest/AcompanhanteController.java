package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.AcompanhanteDTO;
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
	public ResponseEntity<List<AcompanhanteDTO>> listarTodos() {
		return ResponseEntity.ok(acompanhanteService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AcompanhanteDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(acompanhanteService.buscarPorID(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AcompanhanteDTO> salvar(@RequestBody AcompanhanteDTO acompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(acompanhanteService.saveDTO(acompanhante));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<AcompanhanteDTO> atualizar(@PathVariable Long id, @RequestBody AcompanhanteDTO acompanhanteAtualizado) {
		return ResponseEntity.ok(acompanhanteService.atualizar(id, acompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		acompanhanteService.delete(id);
		return ResponseEntity.noContent().build();

	}
}
