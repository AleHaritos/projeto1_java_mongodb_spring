package ale.haritos.projeto1_Springboot.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class Handler {

	@ExceptionHandler(NotFound.class)
	public ResponseEntity<StandardException> notFound(NotFound e, HttpServletRequest request) {	
		String error = "Not found id";
		HttpStatus status = HttpStatus.NOT_FOUND;
		
		StandardException se = new StandardException(Instant.now(), error, e.getMessage(), request.getRequestURI(), status.value());
		
		return ResponseEntity.status(status).body(se);
	}
	
	@ExceptionHandler(BadRequest.class)
	public ResponseEntity<StandardException> badRequest(BadRequest e, HttpServletRequest request) {	
		String error = "Bad request";
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		StandardException se = new StandardException(Instant.now(), error, e.getMessage(), request.getRequestURI(), status.value());
		
		return ResponseEntity.status(status).body(se);
	}
}
