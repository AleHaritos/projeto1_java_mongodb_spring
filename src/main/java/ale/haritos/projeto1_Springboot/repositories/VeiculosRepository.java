package ale.haritos.projeto1_Springboot.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import ale.haritos.projeto1_Springboot.entities.Veiculos;

@Repository
public interface VeiculosRepository extends MongoRepository<Veiculos, String>{

}
