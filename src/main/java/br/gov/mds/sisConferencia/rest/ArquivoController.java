package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.service.ArquivoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/arquivos")
public class ArquivoController {

	private final ArquivoService arquivoService;

	@GetMapping
	public ResponseEntity<List<ArquivoDTO>> listarTodos() {
		return ResponseEntity.ok(arquivoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<ArquivoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(arquivoService.buscarPorID(id));

	}

	@PostMapping
	public ResponseEntity<ArquivoDTO> salvar(@RequestBody ArquivoDTO arquivo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(arquivoService.saveDTO(arquivo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<ArquivoDTO> atualizar(@PathVariable Long id, @RequestBody ArquivoDTO arquivoAtualizado) {
		return ResponseEntity.ok(arquivoService.atualizar(id, arquivoAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		arquivoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
