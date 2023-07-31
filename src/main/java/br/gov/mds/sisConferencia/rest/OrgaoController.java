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

import br.gov.mds.sisConferencia.service.OrgaoService;
import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

	private final OrgaoService orgaoService;

	@GetMapping
	public ResponseEntity<List<OrgaoDTO>> listarTodos() {
		return ResponseEntity.ok(orgaoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrgaoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(orgaoService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<OrgaoDTO> salvar(@RequestBody OrgaoDTO orgao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orgaoService.saveDTO(orgao));
	}

	@PutMapping("/{id}")
	public ResponseEntity<OrgaoDTO> atualizar(@PathVariable Long id, @RequestBody OrgaoDTO orgaoAtualizado) {
		return ResponseEntity.ok(orgaoService.atualizar(id, orgaoAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		orgaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}