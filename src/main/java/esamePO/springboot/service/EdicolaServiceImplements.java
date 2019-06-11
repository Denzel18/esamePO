package esamePO.springboot.service;

import org.springframework.stereotype.Service;
import esamePO.springboot.model.Edicola;
import esamePO.springboot.model.Response;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * La classe che ci permette la realizzazione e l'implementazione di metodi dediti 
 * all'elaborazione di informazioni richiesta dall'utente
 * 
 * @author denis bernovschi
 * @version 1.5
 *
 */


@Service("edicolaService")
public class EdicolaServiceImplements  implements EdicolaService {

	private static ArrayList<Edicola> edicole;

	/**
	 *  il blocco di codice che permette la popolazione dell'array list di edicole 
	 *  con cui elaborare di seguito le informazioni necessarie all'utente 
	 */
	static{
		try {
			edicole= populate();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserCSVException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Edicola> getEdicole() {
		return edicole;
	}

	/**
	 * La funzione restituisce l'edicola in base all'id se è pervenuta altrimenti restituisce null
	 * @param id l'id del oggetto edicola che stiamo cercando
	 */
	public Edicola getEdicolaById(int id) {
		for(Edicola Edicola : edicole){
			System.out.println("CODICE : "+Edicola.getCodice());
			if(Edicola.getId() == id){
				return Edicola;
			}
		}
		return null;
	}

	/**
	 * La funzione restituisce l'edicola in base al codice se è pervenuta altrimenti restituisce null
	 * @param codice il codice del oggetto edicola che stiamo cercando
	 */
	public Edicola getEdicolaByCodice(String codice) {
		for(Edicola Edicola : edicole){
			if(Edicola.getCodice().equals(codice.trim())){
				return Edicola;
			}
		}
		return null;
	}

	/**
	 * 
	 * @param variable variabile su cui fare il conteggio
	 * @param value il valore che la variabile deve assumere al fine di effettuare il conteggio
	 * @return x il conteggio effettivo
	 * @throws IOException visto che ci sono operazioni di lettura/scrittura è opportuno inserire l'IOException
	 */
	private int count(String variable, String value) throws IOException{
		int x = 0; 
		switch(variable) {
		case "municipio": 
			x = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.getMunicipio() == Integer.parseInt(value)){
					x++;
				}
			}
			break;

		case "venditaEsclusiva":
			x = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.isVenditaEsclusiva() == Boolean.parseBoolean(value)){
					x++;
				}
			}
			break;

		case "formaVendita":
			x = 0 ;
			for(Edicola Edicola : edicole){
				if(Edicola.getFormaVenditaEdicole().replace(" ", "").equals(value.replace(" ", ""))){
					x++;
				}
			}
			break;
		}
		return x;
	}

	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (COUNT) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */
	public Response countEdicolaByVariable (String variable, String value) throws IOException {
		int count = -1; 
		Response risposta = null; 
		switch(variable) {
		case "municipio": 
			count = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.getMunicipio() == Integer.parseInt(value)){
					count++;
				}
			}
			risposta = new Response ("Hai ricercato il numero di edicole presenti nel municipio : "+value,
					"Sono presenti : "+count+ " edicole nel municipio "+value);
			break;

		case "venditaEsclusiva":
			count = 0; 
			for(Edicola Edicola : edicole){
				if(Edicola.isVenditaEsclusiva() == Boolean.parseBoolean(value)){
					count++;
				}
			}
			risposta = new Response ("Hai ricercato il numero di edicole con vendita esclusiva uguale a : "+value,
					"Sono presenti : "+count+ " edicole con vendita esclusiva uguale a : "+value);
			break;

		case "formaVendita":
			count = 0 ;
			for(Edicola Edicola : edicole){
				if(Edicola.getFormaVenditaEdicole().replace(" ", "").equals(value.replace(" ", ""))){
					count++;
				}
			}
			risposta = new Response ("Hai ricercato il numero di edicole con la forma di vendita : "+value,
					"Sono presenti : "+count+ " edicole, con la forma di vendita :  "+value);
			break;
		}

		return risposta;
	}
	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (MAX) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */

	public Response maxEdicolaByVariable(String variable) throws IOException {
		String msg = "" ;
		Response risposta = null; 

		switch(variable) {
		case "municipio":
			int maximum = 0;
			int municipio = 0;
			for(Edicola Edicola : edicole){
				int max = count ("municipio", Integer.toString( Edicola.getMunicipio()));
				if(maximum < max) {
					maximum = max; 
					municipio = Edicola.getMunicipio();
				}	
			}
			msg = "Il municipio con il maggior numero di edicole è il : "+municipio+ ", numero di edicole : "+maximum;
			risposta = new Response ("Hai ricercato il numero max di edicole in base al  : "+variable,msg);
			break;
		case "venditaEsclusiva":
			int venditaEsclusivaTrue = count ("venditaEsclusiva", "true");
			int venditaEsclusivaFalse = count ("venditaEsclusiva", "false");

			if(venditaEsclusivaTrue < venditaEsclusivaFalse) {
				msg = "Sono presenti più edicole senza la vendita esclusiva, sono infatti : "+venditaEsclusivaFalse;
			}else {
				msg = "Sono presenti più edicole con la vendita esclusiva, sono infatti : "+venditaEsclusivaTrue;
			}
			risposta = new Response ("Hai ricercato il numero max di edicole 'con' e 'senza' vendita esclusiva",msg);
			break;
		case "formaVendita":
			String formaVendita="";
			int n = 0; int maxFV = 0; 
			for(Edicola Edicola : edicole){
				n = count("formaVendita",Edicola.getFormaVenditaEdicole());
				if(maxFV < n) {
					maxFV = n ; 
					formaVendita = Edicola.getFormaVenditaEdicole();
				}


			}
			msg = "il numero massimo di edicole in base ad una determinata forma vendita è : "+maxFV+ " e la forma vendità più gettonata è : "+formaVendita;
			risposta = new Response ("Hai ricercato il numero max di edicole in base al  : "+variable,msg);
			break;
		}
		return risposta;
	}
	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (MIN) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */
	public Response minEdicolaByVariable(String variable) throws IOException {
		String msg = "" ;
		Response risposta = null; 

		switch(variable) {
		case "municipio":
			int minum = 1000000;
			int municipio = 0;
			for(Edicola Edicola : edicole){
				int min = count ("municipio", Integer.toString( Edicola.getMunicipio()));
				if(minum > min) {
					minum = min; 
					municipio = Edicola.getMunicipio();
				}	
			}
			msg = "Il municipio con il minur numero di edicole è il : "+municipio+ ", numero di edicole : "+minum;
			risposta = new Response ("Hai ricercato il numero min di edicole in base al  : "+variable,msg);
			break;
		case "venditaEsclusiva":
			int venditaEsclusivaTrue = count ("venditaEsclusiva", "true");
			int venditaEsclusivaFalse = count ("venditaEsclusiva", "false");

			if(venditaEsclusivaTrue < venditaEsclusivaFalse) {
				msg = "Sono presenti meno edicole con la vendita esclusiva, sono infatti : "+venditaEsclusivaTrue;
			}else {
				msg = "Sono presenti meno edicole senza la vendita esclusiva, sono infatti : "+venditaEsclusivaFalse;
			}
			risposta = new Response ("Hai ricercato il numero max di edicole 'con' e 'senza' vendita esclusiva",msg);
			break;
		case "formaVendita":
			String formaVendita="";
			int min = 0;
			int minFV = 1000000; 
			for(Edicola Edicola : edicole){
				min = count("formaVendita",Edicola.getFormaVenditaEdicole());
				if(minFV > min) {
					minFV = min ; 
					formaVendita = Edicola.getFormaVenditaEdicole();
				}
			}
			msg = "il numero minimo di edicole in base ad una determinata forma vendita è : "+minFV+ " e la forma vendità più gettonata è : "+formaVendita;
			risposta = new Response ("Hai ricercato il numero min di edicole in base al  : "+variable,msg);
			break;
		}
		return risposta;
	}
	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (METADATA) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */
	public Response getMetaData() {
		Response risposta = null; 
		String msg ="long : id , String : codice ,"
				+ " String : ubicazione "+
				"String : areaDiCompetenza,"
				+ " String : descrizioneVia,"
				+ " String : Civico,"
				+ " int : codiceVia,"
				+ " String : Localita,"
				+ " String : formaVenditaEdicole,"
				+ " boolean : VenditaEsclusiva,"
				+ " int : municipio,"
				+ " double : LONGIT,"
				+ " double : LATIT,"
				+ " double[] : location";
		risposta = new Response ("Hai richiesto i metadata", msg);
		return risposta; 

	}
	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (AVG) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */

	public Response avgEdicolaByVariable (String variable) throws IOException{
		String msg = "" ;
		Response risposta = null;
		int somma = 0;
		double media = 0.0;
		int i = 0;
		switch(variable) {
		case "municipio":

			for( i = 1 ; i < 10 ; i++){
				somma += count ("municipio", Integer.toString(i));
			}
			media = (double)somma/(double) 9;
			msg = "La media di Edicole per municipio e' : "+media;
			risposta = new Response ("Hai cercato media di edicole per municipio",msg);
			break;
		case "venditaEsclusiva":
			int venditaEsclusivaTrue = count ("venditaEsclusiva", "true");
			int venditaEsclusivaFalse = count ("venditaEsclusiva", "false");

			msg = "La media di edicole con vendita esclusiva e' pari a : "+(double)venditaEsclusivaTrue/(double)edicole.size();
			msg+= " ,mentre la media di edicole senza vendita esclusiva e' pari a : "+(double)venditaEsclusivaFalse/(double)edicole.size();

			risposta = new Response ("Hai cercato la media di edicole 'con' e 'senza' vendita esclusiva",msg);
			break;
		case "formaVendita":
			int a = 0, b = 0, c = 0, d = 0, e = 0;
			for(i = 0 ; i < edicole.size(); i++) {
				switch(edicole.get(i).getFormaVenditaEdicole()) {
				case "rivenditainnegozio":
					a++;
					break;
				case "rivenditainsupermercato":
					b++;
					break;
				case "edicolasusuolopubblico":
					c++;
					break;
				case "edicolasusuoloprivato":
					d++;
					break;
				default:
					e++;
					break;
				}
			}
			msg+=" media edicole con forma vendita : rivendita in negozio e' pari a : "+(double)a/(double)edicole.size();
			msg+=" media edicole con forma vendita : rivendita in supermercato e' pari a : "+(double)b/(double)edicole.size();
			msg+=" media edicole con forma vendita : edicola su suolo pubblico e' pari a : "+(double)c/(double)edicole.size();
			msg+=" media edicole con forma vendita : edicola su suolo privato e' pari a : "+(double)d/(double)edicole.size();
			msg+=" media edicole con diversa forma vendita e' pari a : "+(double)e/(double)edicole.size();
			risposta = new Response ("Hai cercato media di edicole per forma di vendita",msg);
			break;

		case "posizione":
			double longitudine = 0; 
			double latitudine = 0;
			for(Edicola Edicola : edicole){
				longitudine += Edicola.getLONGIT(); 
				latitudine += Edicola.getLATIT();
			}
			msg = "La posizione media delle edicole sta a LATITUDINE : "+(latitudine/(double)edicole.size())+" e LONGITUDINE : "+(longitudine/(double)edicole.size());
			risposta = new Response ("Hai cercato la posizione media delle edicole",msg);
			break;
		}

		return risposta;
	}
	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (SUM) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */
	/*
	 * Metodo non implementato, per insufficienza di dati
	 */
	public Response sumData(String data,String value) {
		Response risposta = null;
		String msg = ""; 
		double somma = 0.0; 
		for(Edicola Edicola : edicole){
			switch(value) {
			case "A":
				somma += Edicola.getMunicipio();
				break;
			case "B": 
				somma+= Edicola.getCodiceVia();
				break;
			}
			somma += Edicola.getLONGIT(); 
		}
		msg = "La somma risulta : "+somma;
		risposta = new Response("Hai fatto la somma di :"+value, msg);
		return risposta; 	
	}
	/**
	 * 
	 * @return position la posizione media delle edicole presenti nell'arraylist
	 */
	private double[] avgPosition() {
		double position[] = new double [2];
		double sommaLong = 0.0;
		double sommaLatt = 0.0;
		for(Edicola Edicola : edicole){
			sommaLong += Edicola.getLONGIT(); 
			sommaLatt += Edicola.getLATIT();
		}
		position[0] = (double) sommaLong/ (double) edicole.size();
		position[1] = (double) sommaLatt/ (double) edicole.size();
		return position;
	}
	/**
	 * Ci restituisce l'oggetto risposta valorizzato con la 
	 * richiesta (devSTD) e la risposta al fine di mostrare all'utente il risultato di cio che lui ha richiesto 
	 * @return risposta la risposta da mostrare poi all'utente 
	 */
	public Response devStdData() throws IOException {
		double avg [] = new double[2]; 
		Response risposta = null;
		String msg = "Hai richiesto la deviazione standard della positione delle edicole";
		avg = avgPosition ();

		double diffLong = 0.0;
		double diffLatt = 0.0;

		for(Edicola Edicola : edicole){
			diffLong += Math.pow((Edicola.getLONGIT() - avg[0]), 2);
			diffLatt += Math.pow((Edicola.getLATIT() - avg[1]), 2);
		}

		double sigmaLong = (double) diffLong/ (double)edicole.size();
		double sigmaLatt = (double) diffLatt/ (double)edicole.size();

		double devStdLong = Math.sqrt(sigmaLong);
		double devStdLatt = Math.sqrt(sigmaLatt);

		risposta = new Response(msg,"La deviazione standard è LONG : "+devStdLong+ " LATT : "+devStdLatt);
		return risposta; 
	}
	/**
	 * 
	 * @return edicoleS l'arrayList che contiente tutte le edicole recupare dal parse  
	 * @throws IOException dovute alle operazioni di lettura e scrittura dal file 
	 * @throws ParserCSVException dovute alle operazioni di parsing 
	 */
	private static ArrayList<Edicola> populate() throws IOException, ParserCSVException{
		ArrayList<Edicola> edicoleS = new ArrayList<Edicola>();

		String filenameJSON = "miofile.json";
		String filenameCSV = "miofile.csv";

		Parser p = new Parser();
		p.download("https://www.dati.gov.it/api/3/action/package_show?id=19eb95bf-6b06-43b8-b28a-e774eb5a7391", "miofile.json");
		String url_csv = p.parseJSON(filenameJSON);
		System.out.println("URL : "+url_csv);
		p.downloadCSV(url_csv, filenameCSV);
		p.parseCSV(p.readFile(filenameCSV));
		
		ArrayList <Edicola> edicole = p.getEdicole();

		System.out.println("edicole memorizzate : "+edicole.size());

		for(int i = 0 ; i < edicole.size() ; i++) {
			edicoleS.add(new Edicola(edicole.get(i)));
		}
		return edicoleS;
	}

}

