package esamePO.springboot.model;

public class Risposta {
	private String message; 
	private String info;

	public Risposta(String message, String info) {
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
