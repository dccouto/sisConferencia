package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;
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
	public ResponseEntity<List<TipoConselheiroDTO>> listarTodos() {
		List<TipoConselheiroDTO> tiposConselheiro = tipoConselheiroService.buscarTodos();
		return ResponseEntity.ok(tiposConselheiro);
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoConselheiroDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoConselheiroService.buscarPorID(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoConselheiroDTO> salvar(@RequestBody TipoConselheiroDTO tipoConselheiro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoConselheiroService.saveDTO(tipoConselheiro));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoConselheiroDTO> atualizar(@PathVariable Long id,
			@RequestBody TipoConselheiroDTO tipoConselheiroAtualizado) {
		return ResponseEntity.ok(tipoConselheiroService.atualizar(id, tipoConselheiroAtualizado));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoConselheiroService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
