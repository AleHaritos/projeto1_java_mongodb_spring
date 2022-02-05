package ale.haritos.projeto1_Springboot.exceptions;

import java.io.Serializable;
import java.time.Instant;

public class StandardException implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Instant timestamp;
	private String error;
	private String message;
	private String path;
	private Integer status;
	
	public StandardException() {
		
	}

	public StandardException(Instant timestamp, String error, String message, String path, Integer status) {
		super();
		this.timestamp = timestamp;
		this.error = error;
		this.message = message;
		this.path = path;
		this.status = status;
	}

	public Instant getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Instant timestamp) {
		this.timestamp = timestamp;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMsg() {
		return message;
	}

	public void setMsg(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
	
}
