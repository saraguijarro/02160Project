
public class ResponseObject {
	int code;
	String message;
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResponseObject(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}
	
	public ResponseObject(String message, int code) {this(code, message);}
	
	
}
