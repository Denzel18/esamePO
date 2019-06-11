package esamePO.springboot.model;

/**
 * 
 * @author denis bernovschi
 * @version = 1.0;
 */
public class Response {

	private String message; 
	private String info;

	public Response(String message, String info) {
		this.message = message;
		this.info = info;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	} 

	

}
