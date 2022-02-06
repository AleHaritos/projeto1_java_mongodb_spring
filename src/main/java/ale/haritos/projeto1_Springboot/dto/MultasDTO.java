package ale.haritos.projeto1_Springboot.dto;

import java.io.Serializable;
import java.time.Instant;

import ale.haritos.projeto1_Springboot.enums.TipoMultas;

public class MultasDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Instant data;
	private TipoMultas tipoMulta;
	
	public MultasDTO() {
		
	}

	public MultasDTO(Integer tipoMulta) {
		super();
		this.data = Instant.now();
		this.tipoMulta = TipoMultas.valueOf(tipoMulta);
	}

	public Instant getData() {
		return data;
	}

	public void setData(Instant data) {
		this.data = data;
	}

	public TipoMultas getTipoMultas() {
		return tipoMulta;
	}

	public void setTipoMultas(Integer tipoMulta) {
		this.tipoMulta = TipoMultas.valueOf(tipoMulta);
	}

	@Override
	public String toString() {
		return "MultasDTO [data=" + data + ", tipoMulta=" + tipoMulta + "]";
	}
	
	
	
}
