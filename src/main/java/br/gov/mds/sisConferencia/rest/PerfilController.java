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

import br.gov.mds.sisConferencia.models.Perfil;
import br.gov.mds.sisConferencia.service.PerfilService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/perfis")
public class PerfilController {
	
	private final PerfilService perfilService;

	@GetMapping
	public ResponseEntity<List<Perfil>> listarTodos() {
		List<Perfil> perfis = perfilService.listarTodos();
		return ResponseEntity.ok(perfis);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Perfil> buscarPorId(@PathVariable Long id) {
		return perfilService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Perfil> salvar(@RequestBody Perfil perfil) {
		Perfil novoPerfil = perfilService.salvar(perfil);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoPerfil);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Perfil> atualizar(@PathVariable Long id, @RequestBody Perfil perfilAtualizado) {
		return perfilService.buscarPorId(id)
				.map(perfil -> {
					perfil.setDescricao(perfilAtualizado.getDescricao());
					Perfil perfilAtualizadoObj = perfilService.salvar(perfil);
					return ResponseEntity.ok(perfilAtualizadoObj);
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		return perfilService.buscarPorId(id)
				.map(perfil -> {
					perfilService.excluir(id);
					return ResponseEntity.noContent().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}

}
