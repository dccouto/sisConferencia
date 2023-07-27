package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.OrgaoDTO;
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
	public ResponseEntity<List<OrgaoDTO>> listarTodos() {
		return ResponseEntity.ok(orgaoService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrgaoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(orgaoService.buscarPorID(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrgaoDTO> salvar(@RequestBody OrgaoDTO orgao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(orgaoService.saveDTO(orgao));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<OrgaoDTO> atualizar(@PathVariable Long id, @RequestBody OrgaoDTO orgaoAtualizado) {
		return ResponseEntity.ok(orgaoService.atualizar(id, orgaoAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		orgaoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}