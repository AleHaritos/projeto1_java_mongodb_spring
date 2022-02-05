package ale.haritos.projeto1_Springboot.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import ale.haritos.projeto1_Springboot.dto.MultasDTO;
import ale.haritos.projeto1_Springboot.dto.ProprietarioDTO;

@Document
public class Veiculos implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	private String id;
	private String modelo;
	private String cor;
	private String placa;
	
	private ProprietarioDTO proprietario;
	
	private List<MultasDTO> multas = new ArrayList<>();
	
	public Veiculos() {
		
	}

	public Veiculos(String id, String modelo, String cor, String placa, ProprietarioDTO proprietario) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.cor = cor;
		this.placa = placa;
		this.proprietario = proprietario;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}
	
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	public ProprietarioDTO getProprietarioDTO() {
		return proprietario;
	}

	public void setProprietarioDTO(ProprietarioDTO proprietario) {
		this.proprietario = proprietario;
	}
	
	public List<MultasDTO> getMultas() {
		return this.multas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Veiculos other = (Veiculos) obj;
		return Objects.equals(id, other.id);
	}
	
}
