package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoRegime;
import br.gov.mds.sisConferencia.service.TipoRegimeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoRegime")
public class TipoRegimeController {

	private final TipoRegimeService tipoRegimeService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoRegime>> listarTodos() {
		return ResponseEntity.ok(tipoRegimeService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoRegime> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoRegimeService.findById(id));

	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoRegime> salvar(@RequestBody TipoRegime tipoRegime) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoRegimeService.save(tipoRegime));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoRegime> atualizar(@PathVariable Long id, @RequestBody TipoRegime tipoRegimeAtualizado) {
		return ResponseEntity.ok(tipoRegimeService.atualizar(id, tipoRegimeAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tipoRegimeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
