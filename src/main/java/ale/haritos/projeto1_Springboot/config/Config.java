package ale.haritos.projeto1_Springboot.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import ale.haritos.projeto1_Springboot.dto.MultasDTO;
import ale.haritos.projeto1_Springboot.dto.ProprietarioDTO;
import ale.haritos.projeto1_Springboot.entities.Proprietario;
import ale.haritos.projeto1_Springboot.entities.Veiculos;
import ale.haritos.projeto1_Springboot.repositories.ProprietarioRepository;
import ale.haritos.projeto1_Springboot.repositories.VeiculosRepository;

@Configuration
public class Config implements CommandLineRunner{

	@Autowired
	private ProprietarioRepository propRepo; 
	
	@Autowired
	private VeiculosRepository veiRepo;
	
	@Override
	public void run(String... args) throws Exception {

		veiRepo.deleteAll();
		propRepo.deleteAll();	
		
		Proprietario p1 = new Proprietario(null, "Alex", "50283391192", "alex@gmail.com");
		Proprietario p2 = new Proprietario(null, "Jorge", "50284381195", "jorge@gmail.com");
		
		propRepo.saveAll(Arrays.asList(p1,p2));
		
		Veiculos v1 = new Veiculos(null, "gol", "preto", "2029-DMH", new ProprietarioDTO(p1));
		Veiculos v2 = new Veiculos(null, "fusca", "azul", "1983-OPG", new ProprietarioDTO(p2));
		
		veiRepo.saveAll(Arrays.asList(v1,v2));
		
		v1.getMultas().add(new MultasDTO(Instant.now(), 1));
		v1.getMultas().add(new MultasDTO(Instant.now(), 2));
		
		veiRepo.saveAll(Arrays.asList(v1,v2));
		
		p1.getVeiculos().add(v1);
		p2.getVeiculos().add(v2);
		
		propRepo.saveAll(Arrays.asList(p1,p2));
	}

}
