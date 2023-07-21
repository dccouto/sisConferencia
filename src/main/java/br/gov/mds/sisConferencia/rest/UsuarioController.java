package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.config.mapper.EntityMapper;
import br.gov.mds.sisConferencia.models.Usuario;
import br.gov.mds.sisConferencia.service.UsuarioService;
import br.gov.mds.sisConferencia.service.dto.UsuarioDTO;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

	private final UsuarioService usuarioService;
	private final EntityMapper<UsuarioDTO, Usuario> mapper;

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<UsuarioDTO>> listarTodos() {
		return ResponseEntity.ok(mapper.toDto(usuarioService.findAll()));
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UsuarioDTO> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(mapper.toDto(usuarioService.findById(id)));

	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<UsuarioDTO> salvar(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(mapper.toDto(usuarioService.save(usuario)));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<UsuarioDTO> atualizar(@PathVariable Long id, @RequestBody Usuario usuarioAtualizado) {
		return ResponseEntity.ok(mapper.toDto(usuarioService.atualizar(id, usuarioAtualizado)));

	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		usuarioService.delete(id);
		return ResponseEntity.noContent().build();

	}
}