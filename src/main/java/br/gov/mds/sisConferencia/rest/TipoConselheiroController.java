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

import br.gov.mds.sisConferencia.service.TipoConselheiroService;
import br.gov.mds.sisConferencia.service.dto.TipoConselheiroDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoConselheiro")
public class TipoConselheiroController {

	private final TipoConselheiroService tipoConselheiroService;

	@GetMapping
	public ResponseEntity<List<TipoConselheiroDTO>> listarTodos() {
		List<TipoConselheiroDTO> tiposConselheiro = tipoConselheiroService.buscarTodos();
		return ResponseEntity.ok(tiposConselheiro);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoConselheiroDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoConselheiroService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<TipoConselheiroDTO> salvar(@RequestBody TipoConselheiroDTO tipoConselheiro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoConselheiroService.saveDTO(tipoConselheiro));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoConselheiroDTO> atualizar(@PathVariable Long id,
			@RequestBody TipoConselheiroDTO tipoConselheiroAtualizado) {
		return ResponseEntity.ok(tipoConselheiroService.atualizar(id, tipoConselheiroAtualizado));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoConselheiroService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
