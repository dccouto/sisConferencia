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

import br.gov.mds.sisConferencia.models.TipoFormato;
import br.gov.mds.sisConferencia.service.TipoFormatoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoFormato")
public class TipoFormatoController {

	private final TipoFormatoService tipoFormatoService;

	@GetMapping
	public ResponseEntity<List<TipoFormato>> listarTodos() {
		return ResponseEntity.ok(tipoFormatoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoFormato> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoFormatoService.findById(id));

	}

	@PostMapping
	public ResponseEntity<TipoFormato> salvar(@RequestBody TipoFormato tipoRegime) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoFormatoService.save(tipoRegime));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoFormato> atualizar(@PathVariable Long id, @RequestBody TipoFormato tipoRegimeAtualizado) {
		return ResponseEntity.ok(tipoFormatoService.atualizar(id, tipoRegimeAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tipoFormatoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
