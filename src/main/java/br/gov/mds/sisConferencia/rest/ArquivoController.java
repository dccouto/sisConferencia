package br.gov.mds.sisConferencia.rest;

import java.util.List;

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
	public ResponseEntity<List<Arquivo>> listarTodos() {
		return ResponseEntity.ok(arquivoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Arquivo> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(arquivoService.findById(id));

	}

	@PostMapping
	public ResponseEntity<Arquivo> salvar(@RequestBody Arquivo arquivo) {
		return ResponseEntity.status(HttpStatus.CREATED).body(arquivoService.save(arquivo));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Arquivo> atualizar(@PathVariable Long id, @RequestBody Arquivo arquivoAtualizado) {
		return ResponseEntity.ok(arquivoService.atualizar(id, arquivoAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		arquivoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
