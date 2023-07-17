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

import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.service.OrgaoService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/orgaos")
@RequiredArgsConstructor
public class OrgaoController {

	private final OrgaoService orgaoService;

	@GetMapping
	public ResponseEntity<List<Orgao>> listarTodos() {
		return ResponseEntity.ok(orgaoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Orgao> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(orgaoService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Orgao> salvar(@RequestBody Orgao orgao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orgaoService.save(orgao));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Orgao> atualizar(@PathVariable Long id, @RequestBody Orgao orgaoAtualizado) {
		return ResponseEntity.ok(orgaoService.atualizar(id, orgaoAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		orgaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}