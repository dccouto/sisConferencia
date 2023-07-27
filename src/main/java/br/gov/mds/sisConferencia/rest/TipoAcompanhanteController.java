package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.service.TipoAcompanhanteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoAcompanhante")
public class TipoAcompanhanteController {
	
	private final TipoAcompanhanteService tipoAcompanhanteService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoAcompanhanteDTO>> listarTodos() {
		return ResponseEntity.ok(tipoAcompanhanteService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoAcompanhanteDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoAcompanhanteService.buscarPorID(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoAcompanhanteDTO> salvar(@RequestBody TipoAcompanhanteDTO tipoAcompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoAcompanhanteService.saveDTO(tipoAcompanhante));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoAcompanhanteDTO> atualizar(@PathVariable Long id, @RequestBody TipoAcompanhanteDTO tipoAcompanhanteAtualizado) {
		return ResponseEntity.ok(tipoAcompanhanteService.atualizar(id, tipoAcompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoAcompanhanteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}