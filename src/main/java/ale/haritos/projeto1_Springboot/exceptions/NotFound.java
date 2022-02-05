package ale.haritos.projeto1_Springboot.exceptions;

public class NotFound extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public NotFound(String msg) {
		super(msg);
	}
}
