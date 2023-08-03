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

import br.gov.mds.sisConferencia.service.PerfilService;
import br.gov.mds.sisConferencia.service.dto.PerfilDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/perfis")
public class PerfilController {
	
	private final PerfilService perfilService;

	@GetMapping
	public ResponseEntity<List<PerfilDTO>> listarTodos() {
		return ResponseEntity.ok(perfilService.buscarTodos());
	}

	@GetMapping("/{id}")
	public ResponseEntity<PerfilDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(perfilService.buscarPorID(id));
	}

	@PostMapping
	public ResponseEntity<PerfilDTO> salvar(@RequestBody PerfilDTO perfil) {
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.saveDTO(perfil));
	}

	@PutMapping("/{id}")
	public ResponseEntity<PerfilDTO> atualizar(@PathVariable Long id, @RequestBody PerfilDTO perfilAtualizado) {
		return ResponseEntity.ok(perfilService.atualizar(id, perfilAtualizado));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		perfilService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
