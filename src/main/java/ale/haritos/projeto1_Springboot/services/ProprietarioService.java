package ale.haritos.projeto1_Springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.entities.Proprietario;
import ale.haritos.projeto1_Springboot.exceptions.NotFound;
import ale.haritos.projeto1_Springboot.repositories.ProprietarioRepository;

@Service
public class ProprietarioService {

	@Autowired
	private ProprietarioRepository repository;
	
	public List<Proprietario> findAll() {
		return repository.findAll();
	}
	
	public Proprietario findById(String id) {
		Optional<Proprietario> p = repository.findById(id);
		
		return p.orElseThrow(() -> new NotFound("Proprietário não encontrado"));
	}
	
	public Proprietario insert(Proprietario p) {
		return repository.save(p);
	}
	
}
