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

import br.gov.mds.sisConferencia.service.TipoInscricaoService;
import br.gov.mds.sisConferencia.service.dto.TipoInscricaoDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoInscricao")
public class TipoInscricaoController {

	private final TipoInscricaoService tipoInscricaoService;

	@GetMapping
	public ResponseEntity<List<TipoInscricaoDTO>> listarTodos() {
		return ResponseEntity.ok(tipoInscricaoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoInscricaoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoInscricaoService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<TipoInscricaoDTO> salvar(@RequestBody TipoInscricaoDTO tipoInscricao) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoInscricaoService.saveDTO(tipoInscricao));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoInscricaoDTO> atualizar(@PathVariable Long id,
			@RequestBody TipoInscricaoDTO tipoInscricaoAtualizado) {
		return ResponseEntity.ok(tipoInscricaoService.atualizar(id, tipoInscricaoAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoInscricaoService.delete(id);
		return ResponseEntity.noContent().build();

	}
}