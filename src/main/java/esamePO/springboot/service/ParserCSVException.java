package esamePO.springboot.service;

public class ParserCSVException extends Exception  {
	/**
	 * 
	 */
	private static final long serialVersionUID = 998618604147926315L;
	private String errore; 
	
	
	public ParserCSVException(){
		super();
		this.errore = "Error during parser CSV, check the print stack trace"; 
	}
	
	public String getErrore() {
		return errore;
	}
	public void setErrore(String errore) {
		this.errore = errore;
	}
	
}
