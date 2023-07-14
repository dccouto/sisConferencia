package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/tipoacompanhantes")
public class TipoAcompanhanteController {
	@Autowired
	private TipoAcompanhanteService tipoAcompanhanteService;

	@GetMapping
	public ResponseEntity<List<TipoAcompanhante>> listarTodos() {
		List<TipoAcompanhante> tiposAcompanhante = tipoAcompanhanteService.listarTodos();
		return ResponseEntity.ok(tiposAcompanhante);
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoAcompanhante> buscarPorId(@PathVariable Long id) {
		return tipoAcompanhanteService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<TipoAcompanhante> salvar(@RequestBody TipoAcompanhante tipoAcompanhante) {
		TipoAcompanhante novoTipoAcompanhante = tipoAcompanhanteService.salvar(tipoAcompanhante);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoTipoAcompanhante);
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoAcompanhante> atualizar(@PathVariable Long id, @RequestBody TipoAcompanhante tipoAcompanhanteAtualizado) {
		return tipoAcompanhanteService.buscarPorId(id)
				.map(tipoAcompanhante -> {
					tipoAcompanhante.setDescricao(tipoAcompanhanteAtualizado.getDescricao());
					TipoAcompanhante tipoAcompanhanteAtualizadoObj = tipoAcompanhanteService.salvar(tipoAcompanhante);
					return ResponseEntity.ok(tipoAcompanhanteAtualizadoObj);
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		return tipoAcompanhanteService.buscarPorId(id)
				.map(tipoAcompanhante -> {
					tipoAcompanhanteService.excluir(id);
					return ResponseEntity.noContent().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}