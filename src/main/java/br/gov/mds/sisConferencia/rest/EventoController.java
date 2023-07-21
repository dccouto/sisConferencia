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

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.service.ArquivoService;
import br.gov.mds.sisConferencia.service.EventoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
public class EventoController {

	private final EventoService eventoService;
	private final ArquivoService arquivoService;

	@GetMapping
	public ResponseEntity<List<Evento>> listarTodos() {
		return ResponseEntity.ok(eventoService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(eventoService.findById(id));
	}

	@PostMapping
	public ResponseEntity<Evento> salvar(@RequestBody Evento evento) {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.save(evento));
	}

	@PutMapping("/{id}")
	public ResponseEntity<Evento> atualizar(@PathVariable Long id, @RequestBody Evento eventoAtualizado) {
		return ResponseEntity.ok(eventoService.atualizar(id, eventoAtualizado));
	}
	
	@PostMapping("/{idEvento}/arquivo")
	public ResponseEntity<Evento> inserirImagem(@PathVariable Long idEvento, @RequestBody Arquivo arquivo) {
		Evento evento = eventoService.findById(idEvento);
		Arquivo imagem = arquivoService.save(arquivo);
		evento.setImagem(imagem);
		return ResponseEntity.ok(eventoService.save(evento));
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		eventoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
