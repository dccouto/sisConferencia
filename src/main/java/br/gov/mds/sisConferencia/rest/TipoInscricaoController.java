package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.service.TipoInscricaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoInscricao")
public class TipoInscricaoController {

	private final TipoInscricaoService tipoInscricaoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoInscricao>> listarTodos() {
		return ResponseEntity.ok(tipoInscricaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoInscricao> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoInscricaoService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoInscricao> salvar(@RequestBody TipoInscricao tipoInscricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoInscricaoService.save(tipoInscricao));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoInscricao> atualizar(@PathVariable Long id,
			@RequestBody TipoInscricao tipoInscricaoAtualizado) {
		return ResponseEntity.ok(tipoInscricaoService.atualizar(id, tipoInscricaoAtualizado));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoInscricaoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}