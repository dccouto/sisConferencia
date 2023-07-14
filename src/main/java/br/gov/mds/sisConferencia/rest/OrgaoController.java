package br.gov.mds.sisConferencia.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import br.gov.mds.sisConferencia.models.Orgao;
import br.gov.mds.sisConferencia.service.OrgaoService;

@RestController
@RequestMapping("/orgaos")
public class OrgaoController {

	@Autowired
	private OrgaoService orgaoService;

	@GetMapping
	public ResponseEntity<List<Orgao>> listarTodos() {
		List<Orgao> orgaos = orgaoService.listarTodos();
		return ResponseEntity.ok(orgaos);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Orgao> buscarPorId(@PathVariable Long id) {
		return orgaoService.buscarPorId(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	@PostMapping
	public ResponseEntity<Orgao> salvar(@RequestBody Orgao orgao) {
		Orgao novoOrgao = orgaoService.salvar(orgao);
		return ResponseEntity.status(HttpStatus.CREATED).body(novoOrgao);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Orgao> atualizar(@PathVariable Long id, @RequestBody Orgao orgaoAtualizado) {
		return orgaoService.buscarPorId(id)
				.map(orgao -> {
					orgao.setNome(orgaoAtualizado.getNome());
					orgao.setAreaAtuacao(orgaoAtualizado.getAreaAtuacao());
					orgao.setCargoAtuante(orgaoAtualizado.getCargoAtuante());
					orgao.setEmail(orgaoAtualizado.getEmail());
					orgao.setIsConselheiro(orgaoAtualizado.getIsConselheiro());
					orgao.setEndereco(orgaoAtualizado.getEndereco());
					orgao.setTelefone(orgaoAtualizado.getTelefone());
					orgao.setTipoRepresentacao(orgaoAtualizado.getTipoRepresentacao());
					orgao.setSeguimento(orgaoAtualizado.getSeguimento());
					orgao.setAmbito(orgaoAtualizado.getAmbito());
					orgao.setConselho(orgaoAtualizado.getConselho());
					Orgao orgaoAtualizadoObj = orgaoService.salvar(orgao);
					return ResponseEntity.ok(orgaoAtualizadoObj);
				})
				.orElse(ResponseEntity.notFound().build());
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> excluir(@PathVariable Long id) {
		return orgaoService.buscarPorId(id)
				.map(orgao -> {
					orgaoService.excluir(id);
					return ResponseEntity.noContent().build();
				})
				.orElse(ResponseEntity.notFound().build());
	}
}