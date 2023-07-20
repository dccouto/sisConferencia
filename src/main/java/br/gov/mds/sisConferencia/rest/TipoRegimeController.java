package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.sisConferencia.models.TipoRegime;
import br.gov.mds.sisConferencia.service.TipoRegimeService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoRegime")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoRegimeController {

	private final TipoRegimeService tipoRegimeService;

	@GetMapping
	public ResponseEntity<List<TipoRegime>> listarTodos() {
		return ResponseEntity.ok(tipoRegimeService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoRegime> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoRegimeService.findById(id));

	}

	@PostMapping
	public ResponseEntity<TipoRegime> salvar(@RequestBody TipoRegime tipoRegime) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoRegimeService.save(tipoRegime));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoRegime> atualizar(@PathVariable Long id, @RequestBody TipoRegime tipoRegimeAtualizado) {
		return ResponseEntity.ok(tipoRegimeService.atualizar(id, tipoRegimeAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tipoRegimeService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
