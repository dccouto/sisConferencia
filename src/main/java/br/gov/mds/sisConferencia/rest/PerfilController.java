package br.gov.mds.sisConferencia.rest;

import java.util.List;

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
	public ResponseEntity<List<Perfil>> listarTodos() {
		return ResponseEntity.ok(perfilService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Perfil> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(perfilService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Perfil> salvar(@RequestBody Perfil perfil) {
		return ResponseEntity.status(HttpStatus.CREATED).body(perfilService.save(perfil));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Perfil> atualizar(@PathVariable Long id, @RequestBody Perfil perfilAtualizado) {
		return ResponseEntity.ok(perfilService.atualizar(id, perfilAtualizado));
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		perfilService.delete(id);
		return ResponseEntity.noContent().build();
	}

}
