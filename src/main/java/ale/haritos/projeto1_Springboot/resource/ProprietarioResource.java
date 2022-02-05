package ale.haritos.projeto1_Springboot.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import ale.haritos.projeto1_Springboot.entities.Proprietario;
import ale.haritos.projeto1_Springboot.entities.Veiculos;
import ale.haritos.projeto1_Springboot.services.ProprietarioService;

@RestController
@RequestMapping(value = "/proprietarios")
public class ProprietarioResource {

	@Autowired
	private ProprietarioService service;
	
	@PostMapping
	public ResponseEntity<Proprietario> insert(@RequestBody Proprietario p) {
		p = service.insert(p);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(p.getId()).toUri();
		return ResponseEntity.created(uri).body(p);
	}
	
	@GetMapping
	public ResponseEntity<List<Proprietario>> findAll() {
		List<Proprietario> proprietarios = service.findAll();
		return ResponseEntity.ok(proprietarios);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Proprietario> findById(@PathVariable String id) {
		Proprietario p = service.findById(id);
		return ResponseEntity.ok(p);
	}
	
	@GetMapping(value = "/veiculos/{id}")
	public ResponseEntity<List<Veiculos>> showVeiculos(@PathVariable String id) {
		Proprietario p = service.findById(id);
		List<Veiculos> veiculos = p.getVeiculos();
		return ResponseEntity.ok(veiculos);
	}
	
}
