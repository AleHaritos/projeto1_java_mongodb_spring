package ale.haritos.projeto1_Springboot.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ale.haritos.projeto1_Springboot.dto.MultasDTO;
import ale.haritos.projeto1_Springboot.dto.ProprietarioDTO;
import ale.haritos.projeto1_Springboot.entities.Proprietario;
import ale.haritos.projeto1_Springboot.entities.Veiculos;
import ale.haritos.projeto1_Springboot.exceptions.BadRequest;
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
	
	public Veiculos createVeiculo(Veiculos v) {
		return repository.save(v);
	}
	
	public Veiculos insertVeiculo(String id, Veiculos v) {
		Proprietario p = propService.findById(id);
		v.setProprietarioDTO(new ProprietarioDTO(p));
		v = repository.save(v);
		propService.addVeiculos(p, v);
		return v;
	}
	
	public Veiculos addMulta(String id, Integer code) {
		try {
			Veiculos v = findById(id);
			v.getMultas().add(new MultasDTO(code));
			return repository.save(v);
		}
		catch(IllegalArgumentException e) {
			throw new BadRequest("Este código de multa não existe");
		}
		
	}
	
	public Veiculos mudarProprietario(String idNovo, String idV) {
		Veiculos v = findById(idV);
		Proprietario novo = propService.findById(idNovo);
		
		if(v.getProprietarioDTO() != null) {
			Proprietario velho = propService.findById(v.getProprietarioDTO().getId());
		
			boolean isRemove = velho.getVeiculos().remove(v);
			if(isRemove == true) {
				novo.getVeiculos().add(v);
				v.setProprietarioDTO(new ProprietarioDTO(novo));
				propService.insert(velho);
				propService.insert(novo);
				return repository.save(v);
			} else {
				throw new NotFound("Veiculos não encontrado");
			}
		} else {
			v.setProprietarioDTO(new ProprietarioDTO(novo));
			novo.getVeiculos().add(v);
			propService.insert(novo);
			return repository.save(v);
		}
		
	}
}
