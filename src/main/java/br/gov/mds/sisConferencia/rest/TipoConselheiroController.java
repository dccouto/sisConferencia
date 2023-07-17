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

import br.gov.mds.sisConferencia.models.TipoConselheiro;
import br.gov.mds.sisConferencia.service.TipoConselheiroService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoconselheiros")
public class TipoConselheiroController {

	private final TipoConselheiroService tipoConselheiroService;

	@GetMapping
	public ResponseEntity<List<TipoConselheiro>> listarTodos() {
		List<TipoConselheiro> tiposConselheiro = tipoConselheiroService.findAll();
		return ResponseEntity.ok(tiposConselheiro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoConselheiro> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoConselheiroService.findById(id));
	}

	@PostMapping
	public ResponseEntity<TipoConselheiro> salvar(@RequestBody TipoConselheiro tipoConselheiro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoConselheiroService.save(tipoConselheiro));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoConselheiro> atualizar(@PathVariable Long id,
			@RequestBody TipoConselheiro tipoConselheiroAtualizado) {
		return ResponseEntity.ok(tipoConselheiroService.atualizar(id, tipoConselheiroAtualizado));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoConselheiroService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
