package ale.haritos.projeto1_Springboot.exceptions;

public class BadRequest extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public BadRequest(String msg) {
		super(msg);
	}

}
