package br.gov.mds.sisConferencia.rest;

import java.util.List;

import br.gov.mds.sisConferencia.service.dto.ArquivoDTO;
import br.gov.mds.sisConferencia.service.dto.EventoDTO;
import br.gov.mds.sisConferencia.service.request.EventoRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import br.gov.mds.sisConferencia.models.Arquivo;
import br.gov.mds.sisConferencia.models.Evento;
import br.gov.mds.sisConferencia.service.ArquivoService;
import br.gov.mds.sisConferencia.service.EventoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/eventos")
@CrossOrigin(origins = "http://localhost:3000")
public class EventoController {

	private final EventoService eventoService;
	private final ArquivoService arquivoService;


	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<List<Evento>> listarTodos() {
		return ResponseEntity.ok(eventoService.findAll());
	}

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Evento> buscarPorId(@PathVariable Long id) {
		return ResponseEntity.ok(eventoService.findById(id));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EventoDTO> salvar(@RequestBody EventoRequest eventoRequest) throws Exception {
		return ResponseEntity.status(HttpStatus.CREATED).body(eventoService.salvar(eventoRequest));
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<EventoDTO> atualizar(@PathVariable Long id, @RequestBody EventoDTO eventoAtualizado) {
		return ResponseEntity.ok(eventoService.atualizar(eventoAtualizado));
	}
	
	@PostMapping("/{idEvento}/arquivo")
	public ResponseEntity<EventoDTO> inserirImagem(@PathVariable Long idEvento, @RequestBody ArquivoDTO arquivoDTO) {
		EventoDTO evento = eventoService.buscarPorID(idEvento);
		ArquivoDTO imagem = arquivoService.saveDTO(arquivoDTO);
		evento.setImagem(imagem);
		return ResponseEntity.ok(eventoService.saveDTO(evento));
	}


	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Void> excluir(@PathVariable Long id) {
		eventoService.delete(id);
		return ResponseEntity.noContent().build();
	}
}
