package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.service.TipoAcompanhanteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoacompanhantes")
public class TipoAcompanhanteController {
	
	private final TipoAcompanhanteService tipoAcompanhanteService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoAcompanhante>> listarTodos() {
		return ResponseEntity.ok(tipoAcompanhanteService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoAcompanhante> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoAcompanhanteService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoAcompanhante> salvar(@RequestBody TipoAcompanhante tipoAcompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoAcompanhanteService.save(tipoAcompanhante));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoAcompanhante> atualizar(@PathVariable Long id, @RequestBody TipoAcompanhante tipoAcompanhanteAtualizado) {
		return ResponseEntity.ok(tipoAcompanhanteService.atualizar(id, tipoAcompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoAcompanhanteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}