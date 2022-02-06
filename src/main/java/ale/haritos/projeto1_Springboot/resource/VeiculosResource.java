package ale.haritos.projeto1_Springboot.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ale.haritos.projeto1_Springboot.entities.Veiculos;
import ale.haritos.projeto1_Springboot.services.ProprietarioService;
import ale.haritos.projeto1_Springboot.services.VeiculoService;

@RestController
@RequestMapping(value = "/veiculos")
public class VeiculosResource {

	@Autowired
	private VeiculoService service;
		
	@Autowired ProprietarioService propService;
	
	@GetMapping
	public ResponseEntity<List<Veiculos>> findAll() {
		List<Veiculos> veiculos = service.findAll();
		return ResponseEntity.ok(veiculos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Veiculos> findById(@PathVariable String id) {
		Veiculos v = service.findById(id);
		return ResponseEntity.ok(v);
	}
	
	@PostMapping
	public ResponseEntity<Veiculos> insertVeiculo(@RequestBody Veiculos v) {
		v = service.createVeiculo(v);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(v.getId()).toUri();
		return ResponseEntity.created(uri).body(v);
	}
	
	@PostMapping(value = "/{id}")
	public ResponseEntity<Veiculos> insertVeiculoComProprietario(@PathVariable String id, @RequestBody Veiculos v) {
		v = service.insertVeiculo(id, v);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(v.getId()).toUri();
		return ResponseEntity.created(uri).body(v);
	}
	
	@PutMapping(value = "/{id}/multa/{cod}")
	public ResponseEntity<Veiculos> addMulta(@PathVariable("id") String id, @PathVariable("cod") Integer code) {
		Veiculos v = service.addMulta(id, code);
		return ResponseEntity.ok(v);
		
	}
	
	@PutMapping(value = "/{id}/novo/{idNovo}")
	public ResponseEntity<Veiculos> mudarProprietario(@PathVariable("id") String id, @PathVariable("idNovo") String idNovo) {
		Veiculos v = service.mudarProprietario(idNovo, id);
		return ResponseEntity.ok(v);
	}
	
}
