package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.TipoFormatoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.gov.mds.sisConferencia.models.TipoFormato;
import br.gov.mds.sisConferencia.service.TipoFormatoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoFormato")
@CrossOrigin(origins = "http://localhost:3000")
public class TipoFormatoController {

	private final TipoFormatoService tipoFormatoService;

	@GetMapping
	public ResponseEntity<List<TipoFormatoDTO>> listarTodos() {
		return ResponseEntity.ok(tipoFormatoService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoFormatoDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoFormatoService.buscarPorID(id));

	}

	@PostMapping
	public ResponseEntity<TipoFormatoDTO> salvar(@RequestBody TipoFormatoDTO tipoFormato) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoFormatoService.saveDTO(tipoFormato));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoFormatoDTO> atualizar(@PathVariable Long id, @RequestBody TipoFormatoDTO tipoFormatoAtualizado) {
		return ResponseEntity.ok(tipoFormatoService.atualizar(id, tipoFormatoAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		tipoFormatoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
