package esamePO.springboot.util;

/**
 * Questa classe ci permette ci creare errori personalizzati da visualizzare in caso all'utente della nostra applicazione
 * 
 * @author denis bernovschi
 *
 */
public class CustomErrorType {

    private String errorMessage;

    /**
     * Ci permette di instanziare l'oggetto CustomErrorType con un messaggio 
     * @param errorMessage messaggio che valorizziamo ad ogni nuova istanza dell'oggetto
     */
    public CustomErrorType(String errorMessage){
        this.errorMessage = errorMessage;
    }

    /**
     * Ci ritorna la stringa del messaggio d'errore 
     * @return errorMessage il messaggio settato tramite il costruttore
     */
    public String getErrorMessage() {
        return errorMessage;
    }

}
