package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.service.TipoConselheiroService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoConselheiro")
public class TipoConselheiroController {

	private final TipoConselheiroService tipoConselheiroService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoConselheiro>> listarTodos() {
		List<TipoConselheiro> tiposConselheiro = tipoConselheiroService.findAll();
		return ResponseEntity.ok(tiposConselheiro);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoConselheiro> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoConselheiroService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoConselheiro> salvar(@RequestBody TipoConselheiro tipoConselheiro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoConselheiroService.save(tipoConselheiro));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoConselheiro> atualizar(@PathVariable Long id,
			@RequestBody TipoConselheiro tipoConselheiroAtualizado) {
		return ResponseEntity.ok(tipoConselheiroService.atualizar(id, tipoConselheiroAtualizado));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoConselheiroService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
