package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.TipoInscricao;
import br.gov.mds.sisConferencia.service.TipoInscricaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoInscricao")
public class TipoInscricaoController {

	private final TipoInscricaoService tipoInscricaoService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<TipoInscricaoDTO>> listarTodos() {
		return ResponseEntity.ok(tipoInscricaoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoInscricaoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoInscricaoService.buscarPorID(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoInscricaoDTO> salvar(@RequestBody TipoInscricaoDTO tipoInscricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoInscricaoService.saveDTO(tipoInscricao));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<TipoInscricaoDTO> atualizar(@PathVariable Long id,
			@RequestBody TipoInscricaoDTO tipoInscricaoAtualizado) {
		return ResponseEntity.ok(tipoInscricaoService.atualizar(id, tipoInscricaoAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoInscricaoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}