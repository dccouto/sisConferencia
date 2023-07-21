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

import br.gov.mds.sisConferencia.models.TipoAcompanhante;
import br.gov.mds.sisConferencia.service.TipoAcompanhanteService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoAcompanhante")
public class TipoAcompanhanteController {
	
	private final TipoAcompanhanteService tipoAcompanhanteService;

	@GetMapping
	public ResponseEntity<List<TipoAcompanhante>> listarTodos() {
		return ResponseEntity.ok(tipoAcompanhanteService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoAcompanhante> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoAcompanhanteService.findById(id));
	}

	@PostMapping
	public ResponseEntity<TipoAcompanhante> salvar(@RequestBody TipoAcompanhante tipoAcompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoAcompanhanteService.save(tipoAcompanhante));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoAcompanhante> atualizar(@PathVariable Long id, @RequestBody TipoAcompanhante tipoAcompanhanteAtualizado) {
		return ResponseEntity.ok(tipoAcompanhanteService.atualizar(id, tipoAcompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoAcompanhanteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}