package ale.haritos.projeto1_Springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.dto.MultasDTO;
import ale.haritos.projeto1_Springboot.dto.ProprietarioDTO;
import ale.haritos.projeto1_Springboot.entities.Proprietario;
import ale.haritos.projeto1_Springboot.entities.Veiculos;
import ale.haritos.projeto1_Springboot.exceptions.NotFound;
import ale.haritos.projeto1_Springboot.repositories.VeiculosRepository;

@Service
public class VeiculoService {

	@Autowired
	private VeiculosRepository repository;
	
	@Autowired
	private ProprietarioService propService;
	
	public List<Veiculos> findAll() {
		return repository.findAll();
	}
	
	public Veiculos findById(String id) {
		Optional<Veiculos> v = repository.findById(id);
		return v.orElseThrow(() -> new NotFound("Veículo não encontrado"));
	}
	
	public Veiculos insertVeiculo(Veiculos v) {
		propService.addVeiculos(v);
		return repository.save(v);
	}
	
	public Veiculos addMulta(String id, MultasDTO multa) {
		Veiculos v = findById(id);
		v.getMultas().add(multa);
		return repository.save(v);
	}
	
	public Veiculos mudarProprietario(String idNovo, String idV) {
		Veiculos v = findById(idV);
		Proprietario velho = propService.findById(v.getProprietarioDTO().getId());
		Proprietario novo = propService.findById(idNovo);
	
		boolean isRemove = velho.getVeiculos().removeIf(x -> x.getId() == v.getId());
		if(isRemove == true) {
			novo.getVeiculos().add(v);
			v.setProprietarioDTO(new ProprietarioDTO(novo));
			return v;
		} else {
			throw new NotFound("Veiculos não encontrado");
		}
	}
}
