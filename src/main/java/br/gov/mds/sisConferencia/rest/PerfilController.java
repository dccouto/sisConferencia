package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.PerfilDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.service.PerfilService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/perfis")
public class PerfilController {
	
	private final PerfilService perfilService;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<PerfilDTO>> listarTodos() {
		return ResponseEntity.ok(perfilService.buscarTodos());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PerfilDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(perfilService.buscarPorID(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PerfilDTO> salvar(@RequestBody PerfilDTO perfil) {
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.saveDTO(perfil));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<PerfilDTO> atualizar(@PathVariable Long id, @RequestBody PerfilDTO perfilAtualizado) {
		return ResponseEntity.ok(perfilService.atualizar(id, perfilAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		perfilService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
