package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.service.OrgaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

	private final OrgaoService orgaoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Orgao>> listarTodos() {
		return ResponseEntity.ok(orgaoService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Orgao> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(orgaoService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Orgao> salvar(@RequestBody Orgao orgao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orgaoService.save(orgao));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Orgao> atualizar(@PathVariable Long id, @RequestBody Orgao orgaoAtualizado) {
		return ResponseEntity.ok(orgaoService.atualizar(id, orgaoAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		orgaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}