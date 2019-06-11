package esamePO.springboot.model;

/**
 * La classe del model dedita all'interazione con l'utente 
 * @author denis bernovschi
 * @version 1.0
 */
public class Response {

	private String message; 
	private String info;

	/**
	 * Il costruttore ci permette di instanziare l'oggetto Response con valori...
	 * @param message il messaggio contiene la richiesta dell'utente 
	 * @param info contiene la risposta da far recapitare all'utente
	 */
	public Response(String message, String info) {
		this.message = message;
		this.info = info;
	}
	/**
	 * 
	 * @return message la richiesta dell'utente 
	 */
	public String getMessage() {
		return this.message;
	}
	/**
	 * Serve a valorizzare la richiesta dell'utente in un secondo momento 
	 * @param message la richiesta dell'utente
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * 
	 * @return info la risposta da recapitare all'utente
	 */
	public String getInfo() {
		return info;
	}
	/**
	 * Serve a valorizzare la risposta da recapitare all'utente in un secondo momento 
	 * @param info la risposta dell'utente
	 */
	public void setInfo(String info) {
		this.info = info;
	}
	
	/**
	 * @return String  il toString() dell'oggetto Response
	 */
	public String toString() {
		return "Response [getMessage()=" + getMessage() + ", getInfo()=" + getInfo() + "]";
	} 
}
