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

import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.service.TipoInscricaoService;

@RestController
@RequestMapping("/tiposinscricao")
public class TipoInscricaoController {

	@Autowired
	private TipoInscricaoService tipoInscricaoService;

	@GetMapping
	public ResponseEntity<List<TipoInscricao>> listarTodos() {
		return ResponseEntity.ok(tipoInscricaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoInscricao> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoInscricaoService.findById(id));
	}

	@PostMapping
	public ResponseEntity<TipoInscricao> salvar(@RequestBody TipoInscricao tipoInscricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoInscricaoService.save(tipoInscricao));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoInscricao> atualizar(@PathVariable Long id,
			@RequestBody TipoInscricao tipoInscricaoAtualizado) {
		return ResponseEntity.ok(tipoInscricaoService.atualizar(id, tipoInscricaoAtualizado));

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoInscricaoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}