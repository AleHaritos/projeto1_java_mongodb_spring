package ale.haritos.projeto1_Springboot.enums;


public enum TipoMultas {
	VELOCIDADE(1),
	ESTACIONAMENTO(2);
	
	
	private Integer descricao;
	
	TipoMultas(int i) {
		this.descricao = i;
	}

	public Integer getDescricao() {
		return descricao;
	}
	
	public static TipoMultas valueOf(int code) {
		for (TipoMultas value: TipoMultas.values()) {
			if (value.getDescricao() == code) {
				return value;
			}
		} throw new IllegalArgumentException();	
	}
}
