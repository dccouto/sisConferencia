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

import br.gov.mds.sisConferencia.service.ArquivoService;
import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
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
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		arquivoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
