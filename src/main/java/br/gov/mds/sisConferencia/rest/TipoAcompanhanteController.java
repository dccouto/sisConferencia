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

import br.gov.mds.sisConferencia.service.TipoAcompanhanteService;
import br.gov.mds.sisConferencia.service.dto.TipoAcompanhanteDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tipoAcompanhante")
public class TipoAcompanhanteController {
	
	private final TipoAcompanhanteService tipoAcompanhanteService;

	@GetMapping
	public ResponseEntity<List<TipoAcompanhanteDTO>> listarTodos() {
		return ResponseEntity.ok(tipoAcompanhanteService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<TipoAcompanhanteDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(tipoAcompanhanteService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<TipoAcompanhanteDTO> salvar(@RequestBody TipoAcompanhanteDTO tipoAcompanhante) {
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoAcompanhanteService.saveDTO(tipoAcompanhante));
	}

	@PutMapping("/{id}")
	public ResponseEntity<TipoAcompanhanteDTO> atualizar(@PathVariable Long id, @RequestBody TipoAcompanhanteDTO tipoAcompanhanteAtualizado) {
		return ResponseEntity.ok(tipoAcompanhanteService.atualizar(id, tipoAcompanhanteAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		tipoAcompanhanteService.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}