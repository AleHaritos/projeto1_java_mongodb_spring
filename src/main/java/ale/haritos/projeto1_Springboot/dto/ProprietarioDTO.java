package ale.haritos.projeto1_Springboot.dto;

import java.io.Serializable;

import ale.haritos.projeto1_Springboot.entities.Proprietario;

public class ProprietarioDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public ProprietarioDTO() {
		
	}
	
	public ProprietarioDTO(Proprietario prop) {
		this.id = prop.getId();
		this.nome = prop.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
}
